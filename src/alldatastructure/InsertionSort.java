
package alldatastructure;


public class InsertionSort {
    static int[]arr = {400,3,200,10,12,1,5,6};
    
    public static void main(String[] args) {
        
        insertionSort(arr);
        System.out.println("After insertion sort");
        System.out.println();
        for(int x:arr)
            System.out.print("  "+x);
    }
    public static void insertionSort(int arr[])
    {
        for(int i = 0 ; i<arr.length-1 ; i++)
        {
            for(int j=i ; j>=0;j--)
            {
                if(arr[j]>arr[j+1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
