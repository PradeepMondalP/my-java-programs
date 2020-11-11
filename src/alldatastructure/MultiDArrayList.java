
package alldatastructure;

import java.util.*;

public class MultiDArrayList {
    
    public static void main(String[] args) {
        
        List<List<Integer>> obj = create2DList();
        
        System.out.println(obj.get(0));
    }
    
    public static List create2DList()
    {
        List<List<Integer>> x= new ArrayList<>();
        
        x.add(new ArrayList<>(Arrays.asList(2,4,6,8))   );
        
        x.add(new ArrayList<>(Arrays.asList(1,3,5,7))   );
        
        x.get(0).add(10);
        x.get(0).add(0,0);
        
        return x;
    }
}
