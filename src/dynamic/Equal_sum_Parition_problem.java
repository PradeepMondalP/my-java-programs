
package dynamic;

// divide the array wid two sub array , and check any two sub array exists wid the same Sum of Sub Array

public class Equal_sum_Parition_problem {
    
    public static void main(String[] args) {
        
        int arr[]={2,4,8};
        int sum=0;
        for(int x: arr)
            sum+=x;
        if(sum%2!=0) System.out.println("false");
        
         else   checkPossiblePartion(arr,sum/2);
    }

    private static void checkPossiblePartion(int[] arr, int sum) {
        int n=arr.length;
        boolean arr2[][] = new boolean[n+1][sum+1];
        arr2[0][0]=true;
        
        for(int i=1; i<=n ; i++){
            arr2[i][0]=true;
            for(int j=1; j<=sum ; j++)
            {
                if(j<arr[i-1])
                     arr2[i][j]=arr2[i-1][j];
                else{
                    arr2[i][j] = arr2[i-1][j] || arr2[i-1][j-arr[i-1]] ;
                }
            }
        }
        if(arr2[n][sum])
            System.out.println("possible in even sum");
        else
            System.out.println("no posssible in even sum");
    }
}
