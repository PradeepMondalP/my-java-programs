
import java.util.*;
public class HK_problem1_1 {
    
      public static void main(String[] args) throws Exception {
       
       int n =8 ;
       int m = 5;
       int arr[][] = {
           {1,2}, {1,3}  
               ,{1,6}, {3,4} , {4,5} //,{6,5}
          
       };
       int s = 1;
       bfs(n, m, arr, s);
        
    } 
   
   public static void print(int list[])
   {
       System.out.println("...");
        for(int y: list)
            System.out.print(" "+ y);
   }

    static     LinkedList<Integer>list[];
    static     Map<Integer , Integer>map = new LinkedHashMap<>();
    
    private static void bfs(int n, int m, int[][] arr, int src) {
         map.clear();
         list= new LinkedList[n+1];
         int costArray[] = new int[n-1];
         
         for(int i = 1 ; i<=n ; i++){   // initializing 1->N   
              list[i] = new LinkedList<>();
              if(i==n)  continue;
              map.put(i, 99999) ;
         }
         for(int j = 0 ; j< m ; j++)                  //  graph is creation..
             list[arr[j][0]].addLast(arr[j][1]);  
         
         Queue<Integer>que = new ArrayDeque<>();
         que.add(src);
         LinkedList<Integer> temp;
         map.put(src, 0);
         
         while(! que.isEmpty())
         {
             System.out.println("hi");
             int newSrc = que.poll();
             System.out.println("new src "+ newSrc);
             
             if((int) map.get(newSrc)==99999 )
                  map.put(newSrc, 6);
             
             temp = list[newSrc];
             
             if(temp.isEmpty())
                 continue;
              
             for(int i = 0 ; i<temp.size() ; i++)
             {
                  int next = temp.get(i);
                  if( (int) map.get(next) > ((int)map.get(newSrc) +6)    )
                  {
                      map.put(next, (int)map.get(newSrc) +6   );
                      que.add(next);
                  }
             }
           }
        
         int x = 0;
         for(Map.Entry e : map.entrySet())
         {
              if((int)e.getKey()==src)
                    continue;
              if((int)e.getValue()==99999)
                   costArray[x]=-1;
              else
              {
                   costArray[x] = (int)e.getValue();
              }
             x++; 
         }
         print(costArray);
         
         
    }
}
