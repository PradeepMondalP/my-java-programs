
package sample;

import java.util.*;

public class HackerearthPractise1 {
    
    static LinkedList<Integer>[]list;
    static int query[] , color[];
    static int N , noOfQuery;
    
     public static void main(String args[] ) throws Exception {
      Scanner sc = new Scanner(System.in);
      N = sc.nextInt();
      list = new LinkedList[N+1];
      int x , y;
      
      color = new int[N+1];
      for(int j = 1 ; j<=N-1; j++)       // adding NOdes
      {
         x =  sc.nextInt();
         y = sc.nextInt();
         list[x] = new LinkedList<>();
         list[y] = new LinkedList<>();
         list[x].add(y); 
      }
       for(int j = 1 ; j<=N ;j++)      // adding N differ color
           color[j] =sc.nextInt();
       
       noOfQuery = sc.nextInt();   // no of Query
       query = new int[noOfQuery+1];
       for(int j = 1 ; j<=noOfQuery ;j++)
           query[j] = sc.nextInt();
       calculate(); 
    }

     public static void calculate()
    {
        int tempVal , tempColArr;
        LinkedList<Integer>tempList = new LinkedList<>();;
         for(int i = 1 ; i<=noOfQuery ; i++)    // total no query fetchinng 1 by 1
         {
             tempList.clear();
             tempVal = query[i];       //2
             tempColArr = color[tempVal];   // color =1
             color[tempVal]= -1;  
              
            try
            {
                 tempList = list[tempVal];
                    for(int j  = 0 ; j<tempList.size() ; j++)   // 4,5
                   {
                       int next = tempList.get(j); // 5 , 4

                       if(color[next]==tempColArr)
                            color[next]=-1;
                   }
            }
            catch(Exception e){ continue; }
            System.out.print(count(color));
         }
    }

    public static int count(int arr[])
    {
        int sum=0;
        for(int i =0 ; i<arr.length ; i++)
            if(arr[i]==-1)
                sum++;
        return sum;        
    }
}
