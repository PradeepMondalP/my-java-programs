
package dynamic;

import java.util.*;

public class LonestCommonConsequences {
    
    public static void main(String[] args) {
        
        String str1 = "AATCC";
        String str2 = "ACACG";
        char arr1[] = str1.toCharArray();
        char arr2[] = str2.toCharArray();
        int arr[][] = new int[arr1.length+1][arr2.length+1];
        
        for(int i=1,x=0; i<=arr1.length ; i++,x++){
            for(int j=1,y=0; j<=arr2.length ; j++){
                if(arr1[x]==arr2[y]){
                    arr[i][j] = 1+ arr[i-1][j-1]; y++;
                }else{
                    arr[i][j]=Math.max(arr[i][j-1] , arr[i-1][j]);  y++;
                }
            }
        }
        System.out.println("total lcs possible is "+ arr[arr1.length][arr2.length]);
        
        int i=arr1.length , j=arr2.length;
        LinkedList<Character>list = new LinkedList<>();
        
        while(i>0 && j>0)
        {
            if(arr1[i-1]==arr2[j-1]){  list.addFirst(arr1[i-1]); i--;   j--;  }
            else if(arr[i][j-1] > arr[i-1][j])  j--;
            else i--;
        }
        System.out.println("\n "+ list);
        
    }
}
