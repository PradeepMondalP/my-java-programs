
package dynamic;

//  finding max sum from contigious array and sub array
public class TheMaximizationArray {
    
    public static void main(String[] args) {
        
        int arr[]={2, -1, 2, 3, 4, -5};
        int n= arr.length;
        int max , max2=-999;
        max2=arr[n-1];
        
        int nArr[] = new int[n];
        nArr[0] = arr[0];
        max=nArr[0];
        
        
        for(int i= n-2; i>=0;i--){
            max2=Math.max(Math.max(max2, max2+arr[i]) , Math.max(arr[i] , max2)) ;
        }
        for(int i=1;i<n;i++){
            nArr[i]= Math.max(nArr[i-1]+arr[i],arr[i]) ;
            if(nArr[i]>max)   max=nArr[i];
        }
        System.out.println(" \n contigious max "+ max);
        System.out.println(" subarray max2 "+ max2);
       
    }
}
