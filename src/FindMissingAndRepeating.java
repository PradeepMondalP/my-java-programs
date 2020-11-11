
public class FindMissingAndRepeating {
    
    public static void main(String[] args) {
        int arr[] = {2,2};
        int res[] = findTwoElement(arr, 2);
        for(int x : res)
            System.out.print(x+ " ");
    }
    
   static int[] findTwoElement(int arr[], int n) {

        int N=n+1;
        for(int i=0 ; i<n ; i++)
        {
            int index = arr[i]%N;
            --index;
            arr[index]+=N;
        }
        int max=-9999 , a=0 , b=0 , maxIndex=-99;
        for(int i=0 ; i<n ; i++)
        {
             if(arr[i]<N) b=i+1;
             if(arr[i]>max)
             {
                 max=arr[i];
                 a=i+1;
             }
        }
        return new int[]{a,b};
    }
}
