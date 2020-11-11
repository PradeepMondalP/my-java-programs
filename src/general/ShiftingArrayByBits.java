
package general;

public class ShiftingArrayByBits {
    
    public static void main(String[] args) {
        
        int arr[]= {1,0,0};   
        
        for(int i=0 ; i<6; i++){
            printArr(arr);
            rightShift(arr);
        }
    }
    private static void rightShift(int[] arr) {
       int x = arr[0] , y=arr[1] , z=arr[2];
       arr[0]=z ;
       arr[1]=x ;
       arr[2]=y;
    }
    
    
    public static void printArr(int arr[])
    {
        for(int x : arr)
            System.out.print(x+" ");
        System.out.println();
    }

    
}
