
package input;

import java.util.*;

public class GraphInput {
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
    }
}
