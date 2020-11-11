
package hackerrank;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedlistExample {
    
    public static void main(String[] args) {
        
        LinkedList<String > obj = new LinkedList<String>();
        obj.add("hii -> obj1");
        obj.add("bye -> obj1");
        obj.add("Hello  -> obj1");
        obj.add("Bolo  -> obj1");
        
     LinkedList<String>obj2 = new LinkedList<String>();
     obj2.add("hmmmm  -> obj2");
     obj2.add("mmmhhh   -> obj2");
     obj2.addAll(obj);
     
     Iterator<String> it = obj2.iterator();
      while(it.hasNext())
            System.out.print(" "+ it.next());
             
             System.out.println();
     LinkedList<Integer> obj3 = new LinkedList<Integer>();
     obj3.add(3);
     obj3.add(4);
     obj3.add(56);
     
     Iterator it2 = obj3.iterator();
     while(it2.hasNext())
            System.out.println( it2.next());
     
     
     
    }
    
}
