
package dynamic;

// count the toal possible subset for a given Sum

import java.util.Arrays;


public class CountintingTotalPosibleSubset {
    public static void main(String[] args) {
        int arr[] = {1,1,1,1,1};
        Arrays.sort(arr);
        int sum=3 , n = arr.length;
        int arr2[][]= new int[n+1][sum+1];
        
        arr2[0][0]=1;
        
        for(int i =1 ; i<=n ;i++){
            arr2[i][0]=1;
            for(int j=1; j<=sum; j++){
                {
                    if(j>=arr[i-1])
                        arr2[i][j]=arr2[i-1][j]+ arr2[i-1][j-arr[i-1]]  ;
                    else
                        arr2[i][j]=arr2[i-1][j]; 
                         
                }
            }
        }
        
        for(int arrX[] :arr2)
        {
            for(int x :arrX)
                System.out.print(x+" ");
            System.out.println();
        }
        System.out.println("\n\n total possible "+ arr2[n][sum]);
    }
}
