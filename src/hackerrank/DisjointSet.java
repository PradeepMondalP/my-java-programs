
package hackerrank;

import java.util.*;

public class DisjointSet {
    
     private static final Scanner sc = new Scanner(System.in);
    static LinkedList<Integer>mainList[];
    static boolean vis[];
    static LinkedList<Integer>que = new LinkedList<>();
    static int min=Integer.MAX_VALUE , max = Integer.MIN_VALUE;
    
    public static void main(String[] args)  {
       
       int n = sc.nextInt();
       int N=n;
       mainList = new LinkedList[(2*n) +1];
       vis = new boolean[(2*n)+1];

       for(int i=1 ; i<=2*n ; i++)
             mainList[i] = new LinkedList<>();

       while(n-- >0)
       {
           int x = sc.nextInt();
           int y = sc.nextInt();
           mainList[x].add(y);
           mainList[y].add(x);
       }
       LinkedList<Integer>temp;
       

       for(int i=1 ; i<=2*N ; i++)
       {
           if(!vis[i])
           {
               int count=0;
               que.add(i);    vis[i]=true;
               while(!que.isEmpty())
               {
                   int index = que.poll(); 
                   count++;
                 //  System.out.println("removing "+ index);
                   
                   temp=mainList[index];
                   for(int next : temp)
                   {
                       if(!vis[next])
                       {
                          // System.out.println("next "+next);
                           vis[next]=true;
                           que.add(next);
                       }
                   }
               }
               System.out.println("count :"+ count);
               if(count>=max)  max=count;
               if(count<=min && count>1)  min=count;
           }
       }
       System.out.println(min +" "+ max);
      
    }
}
