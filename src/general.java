
import java.util.*;

public class general {
    
    public static void main(String[] args) {
        
//       Scanner sc = new Scanner (System.in);
//       String str  = sc.next();
          
        
       
    }
    
    public static int reverseBits(int n) {
       
        String str = Integer.toBinaryString(n);
      //  System.out.println("binary "+ str);
        StringBuffer sb = new StringBuffer(str);
        while(sb.length()!=32)
             sb.insert(0,0);
        sb.reverse();
        System.out.println("reverse "+ sb);
        int val = Integer.parseInt(sb.toString() ,2);
        System.out.println(val);
        
        return val;
    }
    
    
    
      public boolean isPalindrome(String s) {
        
        s=s.toLowerCase();
        StringBuffer sb = new StringBuffer();
       for(int i=0;i<s.length();i++)
       {
           if(Character.isLowerCase(s.charAt(i)) || Character.isDigit(s.charAt(i)))  sb.append(s.charAt(i));
       }
       
        String orgString=sb.toString();
        int i=-1 , j=orgString.length();
        if(j==1 || j==0) return true;

        while(i++ <j--){
            if(orgString.charAt(i)!=orgString.charAt(j))  return false;
        }
            
        return true;
    }
    
    
    
    
    static int min=Integer.MAX_VALUE;
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K)
    {
                                             // create the graph
        Map<Integer,Map<Integer,Integer>> map=new HashMap<>();
        for(int f[] : flights)
            map.computeIfAbsent(f[0], m->new HashMap<>()).put(f[1] , f[2]);
        
        boolean visited[] = new boolean[n];
        visited[src]=true;
        
        dfs(map, visited , 0 , src , dst , K+1);
        return min==Integer.MAX_VALUE?-1:min;
    }
    
    public static void dfs(Map<Integer,Map<Integer,Integer>>map , boolean vis[] , int cost ,int src , int dest , int k)
    {
        if(k<0) return ;
        if(src==dest) {
             min=Math.min(min, cost);
             vis[src]=false;
        }
        
        Map<Integer, Integer> tempMap = map.getOrDefault(src, null);
        if(tempMap==null) return;
        
        for(Map.Entry<Integer ,Integer> ent : tempMap.entrySet())
        {
             if(vis[ent.getKey()]  ||  cost+ent.getValue()>=min)  continue;
             vis[ent.getKey()]=true;
             dfs(map, vis, cost+ent.getValue(), ent.getKey(), dest, k-1);
        }
        
    }
}
