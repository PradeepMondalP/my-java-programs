
package google;

import java.util.ArrayList;
import java.util.Arrays;


//  going to infinityy  for larger val......modify it ........      
public class MyOwnSubSetTrying {
    
  static int  SUM=950 ;
  static int checkSUm=0;
 // static   int arr[] = {2,5,6,8};
    static ArrayList<ArrayList> orgList = new ArrayList<>();
  
  
    public static void main(String[] args) {
        
       
       // System.out.println("start time "+  (System.currentTimeMillis()/1000));
        int arr[] = {7 ,12, 12 ,13, 14, 28, 29, 29, 30,
        32 ,32, 34, 41, 45, 46, 56, 61, 61, 62, 63, 65, 68, 
        76 ,77 ,77, 92, 93, 94, 97, 103, 113, 114 ,114 ,120 ,
        135 ,145, 145, 149, 156, 157, 160, 169, 172, 179 ,184 , 
        185, 189, 194, 195, 195 };

        //   int arr[] = {4 ,14 ,15 ,18 ,29 ,32 ,36 ,82 ,95 ,95};
        ArrayList<Integer>list = new ArrayList<>();
       Arrays.sort(arr);
        getSum(arr,0, arr.length-1 , list);
        
        
        System.out.println("checkSum is "+ checkSUm);
        //System.out.println("end time "+  (System.currentTimeMillis()/1000));
    }
    
    
    static void getSum(int arr[] , int sum , int i , ArrayList<Integer> list)
    {
         
        if(i<0)  return;
         if(checkSUm==100)
            return;
        
        if(arr[i]>SUM)  return;
        
        if(i==0 && (arr[i]+sum)>SUM)  return;
        if(sum+arr[i] <=SUM)
        {
            ArrayList<Integer> temp  = new ArrayList<>();
            temp.addAll(list);
            int sumX = sum + arr[i];
            if(checkSUm < sumX){
                       checkSUm = sumX;
            temp.add(arr[i]);
            }
            
            
            
            System.out.println("list is "+ temp);
            System.out.println("addeed   "+sum +"  And...."+ arr[i] +"  =  " +sumX);
            
            getSum(arr, sumX, i-1 ,temp);
            temp.clear();
            System.out.println(".............................");
            getSum(arr, sum, i-1 ,temp);
            temp.clear();
            
        }
        else{
            ArrayList<Integer> temp  = new ArrayList<>();
            temp.addAll(list);
            System.out.println("list is "+ temp);
            getSum(arr, sum, i-1 , temp);
            temp.clear();
        }
    }

    
}


