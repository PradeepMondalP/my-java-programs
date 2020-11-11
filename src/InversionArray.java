
import java.math.BigInteger;
import java.util.*;



public class InversionArray {
    
    static BigInteger temp[];
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0)
        {
             int size=sc.nextInt();
             BigInteger arr[] = new BigInteger[size];
             temp = new BigInteger[size];
             
             for(int i=0;i<size ; i++)  arr[i]= sc.nextBigInteger();
             
             int ans = mergeSort(arr , 0 , size-1);
             System.out.println(ans);
             
        }
    }

     static int mergeSort(BigInteger[] arr, int left, int right) {
        int mid=0 , count=0;
        if(left<right)
        {
            mid = (left+right)/2;
            count+= mergeSort(arr, left, mid);
            count+= mergeSort(arr, mid+1, right);
            
            count+= merge(arr , left , mid+1 , right);
        }
        return count;
    }
     
     public static int merge(BigInteger[] arr, int left,int mid, int right)
     {
         int i=left , j=mid , k=left , count=0;
         
         while( (i<=mid-1) && (j<=right) )
         {
             if(arr[i].compareTo(arr[j]) <=0 )
                   temp[k++]=arr[i++];
             else{
                 temp[k++]=arr[j++];
                 count+=mid-i;
             }
         }
         while(i<mid)  temp[k++]=arr[i++];
         while(j<=right)  temp[k++]=arr[j++];
         
         for(i=left;i<=right;i++)  arr[i]=temp[i];
         
         return count;
     }
}
