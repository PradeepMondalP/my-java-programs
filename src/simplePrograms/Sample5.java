
package simplePrograms;

import java.util.Scanner;

public class Sample5 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner (System.in);
        int nodes = sc.nextInt() , edges=sc.nextInt();
        
        int arr[][] = new int[nodes+1][nodes+1];
        
        
        
        for(int i=0 ;i<edges ; i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            
            arr[node1][node2]=1;
        }
        
        for(int i=0 ; i<arr.length ;i++)
        {
            for(int j=0 ; j<arr[0].length ; j++)
            {
                if(arr[i][j]==1)
                    System.out.print(i+"->"+j+ "  ");
            }
            
            System.out.println();
        }
    }
}
