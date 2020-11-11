package google;


import java.util.ArrayList;
import java.util.Arrays;


public class Own2 {
    
     static int  SUM=17 ;
     static int checkSUm=0;
     static  int count = 0;
     static int arr[] = {8,2,5,6};
   //  static int arr[] = {4 ,14 ,15 ,18 ,29 ,32 ,36 ,82 ,95 ,95};
     static ArrayList<Integer> l = new ArrayList<>();
     static int indexArr[] = new int[arr.length];
          
     
  
    public static void main(String[] args) {
      
//     
//        int arr[] = {7 ,12, 12 ,13, 14, 28, 29, 29, 30,
//        32 ,32, 34, 41, 45, 46, 56, 61, 61, 62, 63, 65, 68, 
//        76 ,77 ,77, 92, 93, 94, 97, 103, 113, 114 ,114 ,120 ,
//        135 ,145, 145, 149, 156, 157, 160, 169, 172, 179 ,184 , 
//        185, 189, 194, 195, 195 };
    //    int arr[] = {5,2,6,8};
            for(int m : arr)
                l.add(m);
            
            
           ArrayList<Integer>list = new ArrayList<>();
           getSum(arr,0, arr.length-1 , list);
        
           System.out.println("checkSum is "+ checkSUm);
           System.out.println("count is "+ count);
           
           System.out.println("index arr");
           for(int g=0;g<indexArr.length ; g++)
           {
               if(indexArr[g]>0)
                   System.out.print(" " +g);
           }
        
    }

    private static void getSum(int[] arr, int sum, int i, ArrayList<Integer> list) {
        ArrayList<Integer> temp;
        if(i<0 || checkSUm==SUM)   return;
        
        int sumX = sum+arr[i];
        if(sumX<=SUM)
        {
              temp = new ArrayList(list);
              temp.add(arr[i]);
              
                    if(sumX> checkSUm)
                    {
                          checkSUm = sumX;
                          count++;
                          
                          for(int j = 0 ; j<indexArr.length ; j++)
                             indexArr[j]=-1;
                          
                           temp.forEach((y) -> {indexArr[l.indexOf(y)]=1; });
                    }
                    
                     System.out.println("adding "+ sum +"  +  "  + arr[i]  +"  =  "  +sumX);
                     System.out.println("list= "+ temp);
                    
                    ArrayList x = new ArrayList();
                    x.addAll(temp);
                    
                    getSum(arr, sumX, i-1, temp);
                    
                    System.out.println("..............................");
                    temp.clear();
                    getSum(arr, sum, i-1, list);
        }
        else
           getSum(arr, sum, i-1, list);
    
    }
}
