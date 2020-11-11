
import java.util.*;


public class AllPermutaionPfNumber {
    
    
   //static Set<Integer>set = new HashSet<>();
    public static void main(String[] args) {
        
        int arr[] = {1,2,3,4,5};
        List<List<Integer>>res =new ArrayList<>();
        long startTime = System.currentTimeMillis();
        solve(arr ,res , new ArrayList<Integer>()  );
        long stopTime = System.currentTimeMillis();
        System.out.println(res);
        System.out.println("time taken : "+(stopTime-startTime));
        
    }

     static void solve(int[] nums, List<List<Integer>> res, ArrayList<Integer> list) {
         if(list.size()==nums.length){
                res.add(new ArrayList<>(list));
                return;
              }
          
          for(int i=0; i<nums.length; i++)
          {
              if(list.contains(nums[i]))  continue;
              list.add(nums[i]); //  list.add(nums[i]);
              
              solve(nums , res , list );
              
              list.remove(list.indexOf(nums[i]));  //   set.remove(nums[i]);
          }
          return;
    }
}
