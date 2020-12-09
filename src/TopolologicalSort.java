
import java.util.*;


public class TopolologicalSort {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner (System.in);
        
        // graph creattion
        int N = sc.nextInt() , V = sc.nextInt();
        
        List<List<Integer>>list =new ArrayList<>();
        for(int i=0 ; i<N ; i++)
           list.add(i , new ArrayList<Integer>());
        
        for(int i=0 ; i<V; i++)
        {
            int node1 = sc.nextInt() , node2 = sc.nextInt();
            list.get(node1).add(node2);
        }
        
        
        solve(list , V);
    }

    static void solve(List<List<Integer>> list, int V) {
        
        boolean vis[] = new boolean[V+1];
        Stack<Integer>stk = new Stack<>();
        
        for(int i=0 ; i<V ; i++)
        {
            if(!vis[i])
                getTopologicalSort(i , list , vis , stk);
        }
        
        System.out.println("printing TOPO order");
        while(!stk.isEmpty())
            System.out.print(stk.pop() +" ");
    }

    static void getTopologicalSort(int i, List<List<Integer>> list, boolean[] vis, Stack<Integer> stk) {
        if(vis[i]) return;
        vis[i]=true;
        
        for(int x : list.get(i))
            if(!vis[x])
                getTopologicalSort(x, list, vis, stk);
        
        stk.push(i);
    }
}


/*

7 6


4 1
4 0
5 0
5 2
2 3
3 1
*/