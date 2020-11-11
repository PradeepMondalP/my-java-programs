package general;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListProgram {

    public static void main(String[] args) {

        List<String> obj = new ArrayList<>();
        obj.add("pradeep");
        obj.add("mondal");
        obj.add("hi");
        obj.add("world");
        obj.add("cup");

        System.out.println("All elements are" + obj);
        System.out.println("is our List empty: " + obj.isEmpty());

        obj.remove(2);
        System.out.println("after removing 3rd elements :  " + obj +"\n");
        
        System.out.println("Is list list contain Pradeep   :" + obj.contains("pradeep"));
        
        
       Collections.sort(obj);
        System.out.println("\n after sorting our list "+ obj);
        
        Collections.reverse(obj);
        System.out.println("\nAfter reversing the list  :"+obj);
    }

}
