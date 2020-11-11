
package dynamic;

import java.util.*;

public class Knapsack_0_by_1 {
    
    static int w[] ={30,20,10 } ;
    static int p[] ={60,100,120};
    public static void main(String[] args) {
        
         //{3,4,6,5};  //  //2, 3, 5, 7,1,  4, 1
          //{2,3,1,4};    //  //10,5, 15,7,6, 18, 3
        int m=50;
        System.out.println(knapSack(m, w.length));
         
    }
    
    public static int knapSack(int weight , int itemContains)
    {
        if(itemContains==0 || weight==0)    return 0;
        if(w[itemContains-1] > weight)  return knapSack(weight, itemContains-1);
        else
            return Math.max( p [itemContains-1] +knapSack(weight-w[itemContains-1], itemContains-1), 
                                                knapSack(weight, itemContains-1));
            
    }
    
}
