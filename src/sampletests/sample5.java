/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sampletests;

import java.util.Scanner;

public class sample5 {

  static String str="abcdefgfhijklmnopqrstuvwxyz";
	public static void main (String[] args)
	{
                Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		StringBuffer res = new StringBuffer();  

		int val = n/26;
		int rem = n%26;

		for(int i=0 ; i<val ; i++)
		  res.append(str);

		char c='a';
		for(int i=0 ; i<rem ; i++)
		{
			res.append(c);
			c++;
		}

		System.out.println(res.toString());     
	}
    
}

