/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplePrograms;

import java.util.Scanner;


public class Sample4 {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int arr1[] = new int[m] , arr2[] = new int[m];
        
        int x=0;
        
        for(int i=0 ; i<m ; i++)
        {
            x++;
            if(arr1[i]!=arr2[i]){
                System.out.println(arr1[i]+"  "+arr2[i] + "  "+ x);
            }
        }
        System.out.println("All equal");
    }
}



/*
285

9 7 0 2 0 9 5 3 8 7 7 5 0 1 4 4 7 4 7 1 8 5 5 6 7 9 0 8 5 9 4 4 6 6 9 8 7 4 4 6 1 1 1 3 4 8 7 3 2 7 5 2 2 0 1 9 2 1 9 7 0 6 3 8 2 2 9 0 7 3 6 0 6 9 4 2 7 1 5 0 8 2 4 1 5 5 2 7 7 4 4 9 0 9 8 2 4 9 2 1 4 0 3 0 0 7 2 9 1 9 1 9 2 6 2 7 1 5 4 0 1 0 0 1 1 0 3 5 9 8 8 3 0 2 5 2 9 9 9 2 8 5 2 0 1 6 7 5 3 3 5 4 5 7 5 7 9 1 2 8 1 1 3 1 3 0 6 4 9 0 7 0 5 1 0 9 7 0 6 3 5 3 7 1 1 3 8 0 6 0 1 7 3 6 0 8 9 6 3 0 8 2 0 6 3 3 5 2 5 1 5 0 4 5 3 7 0 3 0 6 6 3 5 9 9 5 8 8 4 3 1 4 5 1 0 0 4 5 4 1 8 0 2 5 7 7 2 7 1 2 3 7 5 8 6 7 5 6 7 1 9 8 6 6 2 6 6 8 4 1 0 2 3 4 9 0 1 2 9 2 6 2 9 4 2


9 7 0 2 0 9 5 3 8 7 7 5 0 1 4 4 7 4 7 1 8 5 5 6 7 9 0 8 5 9 4 4 6 6 9 8 7 4 4 6 1 1 1 3 4 8 7 3 2 7 5 2 2 0 1 9 2 1 9 7 0 6 3 8 2 2 9 0 7 3 6 0 6 9 4 2 7 1 5 0 8 2 4 1 5 5 2 7 7 4 4 9 0 9 8 2 4 9 2 1 4 0 3 0 0 7 2 9 1 9 1 9 2 6 2 7 1 5 4 0 1 0 0 1 1 0 3 5 9 8 8 3 0 2 5 2 9 9 9 2 8 5 2 0 1 6 7 5 3 3 5 9 5 7 5 7 9 1 2 8 1 1 3 1 3 0 6 4 9 0 7 0 5 1 0 9 7 0 6 3 5 3 7 1 1 3 8 0 6 0 1 7 3 6 0 8 9 6 3 0 8 2 0 6 3 3 5 2 5 1 5 0 4 5 3 7 0 3 0 6 6 3 5 9 9 5 8 8 4 3 1 4 5 1 0 0 4 5 4 1 8 0 2 5 7 7 2 7 1 2 3 7 5 8 6 7 5 6 7 1 9 8 6 6 2 6 6 8 4 1 0 2 3 4 9 0 1 2 9 2 6 2 9 4 2


*/