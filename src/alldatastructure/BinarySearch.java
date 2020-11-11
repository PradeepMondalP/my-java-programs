package alldatastructure;


public class BinarySearch {
    static int[]arr = {2,3,4,5,6,7,8,199,299,300,305};
   
    public static void main(String[] args) {
        
       int x= binarySearch(arr, 0, arr.length-1, 299);
       if(x>1)
            System.out.println("postion is "+x);
       else
            System.out.println("not found");
    }
    
    public static int binarySearch(int arr[] , int b , int e  ,int ele)
    {
        while(b<=e)
        {
            int mid = (b+e)/2;
            if(ele==arr[mid]) 
                return mid;
            
          else  if(ele>arr[mid]) 
                return binarySearch(arr, mid+1, e, ele);
          
            else  if(ele<arr[mid]) 
                return binarySearch(arr, b, mid-1, ele);
            else
                return -1;
        }
        return -1;
    }
}
