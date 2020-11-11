
package Substring;

import java.util.*;


public class Substring {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-- >0)
        {
            int x=sc.nextInt() , y=sc.nextInt();
            String str1=sc.next() , str2=sc.next();
            char arr1[]=str1.toCharArray() , arr2[] = str2.toCharArray();
            
            int arr[][] = new int [y+1][x+1];
            
            for(int i=1 ; i<=y ; i++)
	    {
	        for(int j=1;j<=x;j++)
	        {
	            if(arr2[i-1]==arr1[j-1])   arr[i][j]=1+arr[i-1][j-1];
	            else arr[i][j] = Math.max(arr[i][j-1] , arr[i-1][j]);
	        }
	    }
            
            System.out.println(arr[y][x]);
        }
    }
}
