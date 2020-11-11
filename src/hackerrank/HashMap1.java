
package hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashMap1 {
    
  static Map<String , Integer> map = new HashMap<>();
  
   public static void main(String []argh)
	{
		Scanner in = new Scanner(System.in);
                
		int n=in.nextInt();
		in.nextLine();
		for(int i=0;i<n;i++)
		{
			String name=in.nextLine();
			int phone=in.nextInt();
                        map.put(name, phone);
			in.nextLine();
		}
                
                System.out.println(map);
		while(in.hasNext())
		{
			String key=in.nextLine();
                        key=key.trim();
                        if(key.length()>0)
                        {
                              if(map.containsKey(key))
                              {
                                   System.out.println(key +"="+ map.get(key));
                              }
                              else
                                 System.out.println("Not found");
                        }
		}
	}
}
