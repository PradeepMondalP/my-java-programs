
package practice;


// i am very close to the solution
public class SherlochAndCost {
    
    public static void main(String[] args) {
        
 //      int arr[] = {52 ,60, 50, 90, 84, 35, 56, 64, 52, 20, 43, 19, 12, 73, 48, 93, 43, 78, 
 //             22 ,53, 60, 100, 26, 54, 84};

 //         int arr[] = {14 ,30 ,82, 49, 47, 96, 34, 66, 15, 11, 43, 45,
 //             56 ,77 ,53, 13, 43, 92, 67, 37};

      //  int arr[] = {10,62,30,19,71,49,13,40,16,44,28};
      
   // int arr[] = {55,68,31,80,57,18,34,28,76,55};
  
  //  int arr[] = {100,2,100,2,100};
   
     int arr[] = {79,6,40,68,68,16,40,63,93,49,91};
      
        
        int n=arr.length , sum=0;
        if(arr[0]<arr[1]) arr[0]=1;
        
        
       for(int i=1;i<n-1;i++)
       {
           if(i==n-1){
               if( Math.abs(arr[i]-arr[i-1]) < Math.abs(1-arr[i-1]))
                   arr[i]=1;
               break;
        
           }
           int sum1 , sum2;
           System.out.println("  "+arr[i-1]+"   "+arr[i]+"  "+arr[i+1]);
           sum1= Math.abs(arr[i-1] - 1)+ Math.abs(1-arr[i+1]);            //       with 1
           sum2=Math.abs(arr[i-1] - arr[i])+ Math.abs(arr[i]-arr[i+1]);    //   with val
           
           System.out.println(arr[i]+"-> "+"sum1 :"+ sum1 +"\t sum2 :"+sum2);
           if(sum1>sum2)  arr[i]=1;
           System.out.println();  
         }
       
        System.out.println("array...........");
        for(int x : arr)  System.out.print(x+" ");
        
        for(int j=0;j<n-1;j++)
            sum+=Math.abs( arr[j]- arr[j+1]);
       
        System.out.println("\n\nsum "+ (sum));
    }
}
