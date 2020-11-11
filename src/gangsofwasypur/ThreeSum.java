
package gangsofwasypur;

import java.util.*;

public class ThreeSum {
    
    static int arr[] = {-1,0,1,2,-1,-4};
    static int N = arr.length;
    static Set<ArrayList>mySet = new LinkedHashSet<>();
    
    public static void main(String[] args) {
      
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0 ; i<arr.length ; i++)
        {
            list.clear();
            list.add(arr[i]);
            findAllPossibleSum(list , i , 1);
        }
        
        for(List l : mySet)
            System.out.println(" "+ l);
    }

    private static void findAllPossibleSum(ArrayList<Integer> list, int index, int COUNT) {
       
       ArrayList<Integer>temp;
       
        if(COUNT==3 && getSumOfTheList(list)==0 ){
            Collections.sort(list);            
            mySet.add(new ArrayList(list));
            list.remove(2);                   //removing 3rd elemnt of list..
            return;                            // going back where it was called (backtracking)
        }
        for(int i = index+1 ; i<N ; i++)
            {
                 temp = new ArrayList<>(list);
                 if(i<N)
                 {
                     temp.add(arr[i]);
                     findAllPossibleSum(temp, i , COUNT+1);
                 }
            }
    }
    
    public static int getSumOfTheList(ArrayList<Integer> list)
   {
        int sum=0;
        for(int x:list)
            sum+=x;
        return sum;
    }
}
