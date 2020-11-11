
package google;


//  nOt Working.........
public class SumOfSubsets {
    
    static int subset_count=0;
    
    static void subset_sum(int list[], int sum , int startIndex , int target_sum)
    {
        if(target_sum==sum)
        {
            subset_count++;
             if(startIndex < list.length)
                  subset_sum(list, sum-list[startIndex-1], startIndex, target_sum);
             else
             {
                  for(int i = startIndex ; i<list.length ; i++)
                       subset_sum(list, sum+list[i],i+1, target_sum);
        }
    }
}
    
    public static void main(String[] args) {
        int list[] = {2,5,6,8};
        subset_sum(list, 0,0,6);
        
        System.out.println("total "+ subset_count);
    }
}
