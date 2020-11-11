/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newone;
import java.util.*;

public class PickingNumbers {
    public static void main(String[] args) {
        
      int x =  pickingNumbers(Arrays.asList(1,2,2,3,1,2));
        System.out.println("val "+ x);
    }
    
        public static int pickingNumbers(List<Integer> a) {
       
       LinkedList<Integer>list = new LinkedList<>();
       int max=0 , n=a.size();
       for(int i=0; i<a.size() ; i++)
       {
           list.add(a.get(i));
           for(int j=i+1 ; j<n ;j++)
             {   
               if(list.isEmpty()) break;
               if(Math.abs(a.get(j)- list.getLast())==0 ||
                   Math.abs(a.get(j)- list.getLast())==1 )   list.addLast(a.get(j));
                else  list.poll();
             }
            if(list.size() > max)  max=list.size();
            list.clear();
       }
       return max;

    }
        
        
        /*
        
         
    public static int pickingNumbers(List<Integer> a) {
       
       Collections.sort(a);
        for(int i=a.size()-1;i>=0;i--){
            int count=1;
            int valI=a.get(i);

            for(int j=i-1;j>=0;j--){

                int valJ= a.get(j);
                if(valI-valJ<=1)   count++;
                    
             }
            a.set ( i , count);
        }
        Collections.sort(a);
        return a.get(a.size()-1);

    }
        */
}
