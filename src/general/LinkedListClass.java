package general;

import java.util.LinkedList;
import java.util.List;

public class LinkedListClass {

    public static void main(String[] args) {

        List<String> list1 = new LinkedList<>();
        List<String> list2 = new LinkedList<>();

        list1.add("pradeep");
        list1.add("mondal");
        list1.add("hello");
        list1.add("cup 2019");
        list1.add("world");
        

        System.out.println("list1 is : " + list1);
        
        list2.add("pradeep");
        list2.add(0,"mondal");
        list2.add(0,"hello");
        list2.add(0 , "world");
        
         System.out.println("list2 is : " + list2);
         
         System.out.println("\ncomparing two list and checking for similarities ..");
         System.out.println("is both list same :"+ list1.contains(list2));
         
         List<String> list3 = new LinkedList();
         
         for(String x : list1)
         {
              list3.add( list2.contains(x) ? x : ""  );
         }
         
         list3.remove("");
         System.out.println("list3 :  "+list3);
        

    }
}
