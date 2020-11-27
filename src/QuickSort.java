
public class QuickSort {
    
       public static void main(String[] args) {
       
        int arr[] = {5,4,3,2,1};
        
        quickSort(arr, 0, arr.length-1);
        
        for(int x : arr)
            System.out.print( x + " ");
    }
    
    public static void quickSort(int arr[] , int low , int high)
    {
        if(low<high)
        {
            int j=partition(arr, low, high);
            quickSort(arr, low, j-1);
            quickSort(arr, j+1, high);
        }
    }
    
    public static int partition(int arr[] , int low , int high)
    {
        int pivot = arr[high];  
        int i = (low-1); // index of smaller element 
        for (int j=low; j<high; j++) 
        { 
            // If current element is smaller than the pivot 
            if (arr[j] < pivot) 
            { 
                i++; 
  
                // swap arr[i] and arr[j] 
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
  
        // swap arr[i+1] and arr[high] (or pivot) 
        int temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
  
        return i+1; 
    }
    
    public static void swap(int arr[] , int i , int j)
    {
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
    }
    
}
