
import java.util.ArrayList;
import java.util.List;


// we need unique combinations and same number cannot be repeated

public class CombinationalSum2 {
    public static void main(String[] args) {
        
        int arr[] = {1,1,1,7};
        int target = 8;
        System.out.println(solve(arr , target));
    }

    static List<List<Integer>> solve(int[] arr, int target) {
        List<List<Integer>>res = new ArrayList<>();
        findAllPermutation(arr , res , new ArrayList<>(),0 , target , 0);
        return res;
     }

    static void findAllPermutation(int[] arr, List<List<Integer>> res,
                     List<Integer>list, int start, int target , int sum)
    {
        if(sum==target){
            res.add(new ArrayList<>(list));
            return;
        }
        
        for(int i=start ; i<arr.length ; i++)
        {
            if(sum+ arr[i] <=target)
            {
                sum+=arr[i];
                list.add(arr[i]);
                findAllPermutation(arr, res, list, i+1, target, sum);
                sum-=arr[i];
                list.remove(list.size()-1);
            }
            
            while( i+1<arr.length && arr[i]==arr[i+1]) i++;
        }
    }
}
