
package general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Rough {
    
    public static void main(String[] args) {
        
        int arr[] = {50, 25 , 15,10 , 45, 100 ,200};
        ArrayList list = new ArrayList(Arrays.asList(3,2 , 1));
        
        int pos = getMinPos(arr , list);
        System.out.println("returnred position "+ pos);
    }
     private static int getMinPos(int[] arr, ArrayList<Integer> list) {
        ArrayList temp = new ArrayList();
        for(int x: arr)
            temp.add(x);
        ArrayList OrgList = new ArrayList(temp);
        
        for(int i = 0 ; i< list.size() ; i++)
        {
            int index = list.get(i);    // 3  , 2
           // System.out.println("given index are = "+ index);
            temp.remove(index);
        }
         Collections.sort(temp);
         int val = (int) temp.get(0);
         return OrgList.indexOf(val);
    }
}
