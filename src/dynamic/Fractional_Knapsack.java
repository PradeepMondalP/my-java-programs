
package dynamic;

import java.util.*;

class Kanp
{
   public float weight , profit;
   public double pro_by_wt=0.0f;
    Kanp(float p , float w){
        weight=w;
        profit = p;
        pro_by_wt = profit/weight;
    }

    public double getPro_by_wt() {
        return pro_by_wt;
    }
}
public class Fractional_Knapsack {
    
    public static void main(String[] args) {
        LinkedList<Kanp>list = new LinkedList<>();
        System.out.println("Enter how many obhjects..");
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        while(n-- >0)  list.add(new Kanp(sc.nextInt() , sc.nextInt()));
        
        // sort the list based on the pro/w
        Collections.sort(list, Comparator.comparingDouble(Kanp::getPro_by_wt).reversed());
                
        System.out.println("list aftre sorting is..............."); 
       list.stream().forEach( i-> System.out.print(i.profit
         +"  "+ i.weight +"  "+ i.pro_by_wt +"\n") );
        
        int i=0, wt=0 ,W=15;
        double max=0;
        while(wt<W)
        {
            Kanp obj = list.get(i++);
            //System.out.println("object details "+ obj.);
            if(W-wt < obj.weight){
               max+= obj.profit * ((W-wt)/obj.weight);
               wt=W;
            }
            else
            {
                wt+=obj.weight;
                max+=obj.profit;
            }
            
        }
        System.out.println("max = "+ max);
        
    }
}
