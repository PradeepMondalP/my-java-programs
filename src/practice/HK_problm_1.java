/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

import java.util.*;


// have some isse with multiple test cases..
public class HK_problm_1 {
    static     LinkedList<Integer>list[];
    static     Map<Integer , Integer>map = new LinkedHashMap<>();
    
    static int[] bfs(int n, int m, int[][] arr, int src)
    {
         list= new LinkedList[n+1];
         int costArray[] = new int[n-1];
         for(int i = 1 ; i<=n ; i++){   // initializing 1->N   
              list[i] = new LinkedList<>();
              map.put(i, 99);
         }
         for(int j = 0 ; j<m ; j++)                  //  graph is creation..
             list[arr[j][0]].addLast(arr[j][1]);    

         LinkedList<Integer> main = list[src];   //  list[1]     ----> 2,3
         for(int x = 0 ; x<main.size() ; x++)
         {
              int newSrc = main.get(x);     // src = 2,3
              map.put(newSrc , 6);
              callMyFunction(newSrc , 6 , list , map);
         }
         int x=0;
         for(Map.Entry e :map.entrySet())
         {
             if(src==(int)e.getKey() || x>=n)
                 continue;
             int val =(int) e.getValue();
             if(val==99)  costArray[x]=-1;
             else         costArray[x]=val;
             x++;
         }
         map.clear();
         return costArray;
         
         
    }

    public static void callMyFunction(int src , int wt ,LinkedList []list ,
            Map<Integer,Integer>map)    // 5,18
    {
       if( wt < map.get(src))  
                map.put(src, wt);

        LinkedList<Integer>temp = list[src];    //        ,, 3->4      , , 4-->5
        if(!temp.isEmpty())
            for(int j = 0 ; j<temp.size() ; j++)
             {
                 int next = temp.get(j);  //  next =5
                 callMyFunction(next , wt+6 , list , map);     //     5 , 18
             }
     }
       
   public static void main(String[] args) throws Exception {
       
       int n =5 ;
       int m = 2;
       int arr[][] = {
           {1,2}, {1,3} // ,{3,4} //, {4,5} 
          // {2,3}
       };
       int s = 1;
      int[] list= bfs(n, m, arr, s);
       System.out.println(" \nfinal list = ");
        print(list);
         
    } 
   
   public static void print(int list[])
   {
       System.out.println("...");
        for(int y: list)
            System.out.print(" "+ y);
   }

}
