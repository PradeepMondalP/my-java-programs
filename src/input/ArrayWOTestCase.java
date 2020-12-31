/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package input;

import java.util.*;


public class ArrayWOTestCase {
    
    public static void main(String[] args) throws java.lang.Exception{
        
        try
        {
            Scanner sc = new Scanner (System.in);
            int n = sc.nextInt();
            int arr[] = new int[n];

            for(int i=0 ;i<n ; i++) arr[i] =sc.nextInt();
        }
        catch (Exception e) {
        }
    }
}
