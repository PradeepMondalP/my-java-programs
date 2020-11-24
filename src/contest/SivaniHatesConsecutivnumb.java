/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contest;

import java.util.*;

public class SivaniHatesConsecutivnumb {
    
    public static void main (String[] args)
	 {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    while(t-- >0)
	    {
	        int n = sc.nextInt();
	        List<Integer> list = new ArrayList<>();
	        for(int i=0 ; i<n ; i++)
	             list.add( sc.nextInt() );
	           
	        Collections.sort(list);
	        
	        
	        int sum=0;
	        while( list.size() >0)
	        {
	            int curr = list.get(list.size()-1) ;
	            sum+= curr ;
	            list.remove( list.indexOf(curr) );
	            
	            if( list.contains( curr -1 ) )  list.remove( list.indexOf(curr-1) );
	        }
          
              System.out.println(sum);
	    }
    }
    
}
