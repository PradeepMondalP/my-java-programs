import java.util.*;

public class WeakestRowInMatrix {
    
    public static void main(String[] args) {
        
//        int arr[][] ={{1,1,0,0,0},
//            {1,1,1,1,0},
//            {1,0,0,0,0},
//            {1,1,0,0,0},
//            {1,1,1,1,1}};
//        
//        int x[] = kWeakestRows(arr, 3);
//        for(int  y: x)
//            System.out.print(y+" ");

    int x=Integer.MAX_VALUE;
    int cons=1000000009;

  
    }
    
    public static int[] kWeakestRows(int[][] mat, int k) {
        
        int arr[] = new int[k];
        List<int[]>list = new ArrayList<>();
        
        for(int i=0 ; i<mat.length ; i++)
             list.add(  new int[] {  giveCountOfOnes(mat[i]) , i} );
        
        Collections.sort(list , (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1] );
        
        for(int i=0 ;i<k;i++)
              arr[i]= list.get(i)[1];
        
        return arr;
        
    }
    
    public static int giveCountOfOnes(int arr[])
    {
        int low=0 , high=arr.length;
        while(low<high)
        {
            int mid=low +( high-low)/2;
            if(arr[mid]==1)
                 low=mid+1;
            else
                high=mid;
        }
        return low;
    }
    
    
    //sdgerhsr
     public boolean containsNearbyAlmostDuplicate(int[] arr, int indexDiff, int numDiff) {
        
        if(arr==null || indexDiff==0) return false;
        int cons=1000000009;
        indexDiff%=cons;   numDiff%=cons;
        int n = arr.length;
        List<int[]>list = new ArrayList<>();
        
        for(int i=0 ; i<n ; i++)
            list.add(new int[] {arr[i] , i} );
        
       Collections.sort(list, (a, b) -> a[0]!=b[0] ? a[0]-b[0] : a[1]-b[1]);
        
        for(int i=0 ; i<n-1 ; i++)
        {
            int a[] = list.get(i);
            
            for(int j=i+1 ; j<n ; j++)
            {
                int b[] = list.get(j);
                if( Math.abs(b[0]%cons-a[0]%cons)%cons >numDiff)  break;
                if( Math.abs(b[0]%cons - a[0]%cons)%cons  <=numDiff && 
                        Math.abs(b[1] - a[1])%cons  <= indexDiff) return true;
            }
        }
        return false;
    }
}
