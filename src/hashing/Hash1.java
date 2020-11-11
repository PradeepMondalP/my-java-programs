
package hashing;
import static java.lang.System.out;
import java.util.Hashtable;

public class Hash1 {
    public static void main(String[] args) {
        
        Hashtable<Integer , String> tab = new Hashtable<>();
        tab.put(1, "pradeep"); 
        tab.put(2, "mondal"); 
        tab.put(3, "biriyani"); 
        tab.put(4, "khabi"); 
        
        System.out.println(tab);
        
    }
}
