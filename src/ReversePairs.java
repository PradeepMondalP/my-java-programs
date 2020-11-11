
import java.util.Scanner;


public class ReversePairs {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        temp= new int[n];
        
        for(int i=0;i<n ; i++) arr[i]=sc.nextInt();
        
        System.out.println(calculateReversePairs(arr));
        
        System.out.println("sorted elements");
        for(int x : arr)
            System.out.print(x+" ");
    }

    static int calculateReversePairs(int[] arr) {
        return mergeSort(arr, 0 , arr.length-1);
        
    }

    static int mergeSort(int[] arr, int left, int right) {
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
    
    static int temp[];
    static int merge(int arr[] , int left , int mid , int right)
    {
        int i=left , j=mid , k=left , count=0 , tempMid=mid;
        
        while(i < mid && tempMid<=right)
        {
            long val1=arr[i], val2=2*(long)arr[tempMid];
            if(val1>val2){
                 count+=(mid-i);
                 tempMid++;
            } 
            else i++;
        }
        
        i=left;
         while( (i<=mid-1) && (j<=right) )
         {
             if(arr[i]<=arr[j] )
                   temp[k++]=arr[i++];
             else
                 temp[k++]=arr[j++];
             
         }
         while(i<mid)  temp[k++]=arr[i++];
         while(j<=right)  temp[k++]=arr[j++];
         
         for(i=left;i<=right;i++)  arr[i]=temp[i];
         
         return count;
    }
}


/*

// counted the number

   [2147483647,2147483647,2147483647,2147483647,2147483647,2147483647]
        while(i <= mid)
        {
            if(arr[i] > 2*arr[mid])  count++;
            i++;
        }


5
2147483647 2147483647 2147483647 2147483647 2147483647

6
5 5 -5 -5 -5 5

2* max = 4294967294
         
*/