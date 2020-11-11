
import java.util.*;


public class MinimumNumbeofArrowstoBurstBalloons {
 
    public static void main(String[] args) {
         int arr[][]={{-2147483646,-2147483645},{2147483646,2147483647}};
         System.out.println(findMinArrowShots(arr));
    }
    
    static int findMinArrowShots(int[][] arr) {
        
        int N=arr.length;
        if(N==0 || N==1) return N;
        List<int[]>list = new ArrayList<>();
        for(int x[] : arr)  list.add(x);
        
        Collections.sort(list , (a,b)->a[0]>b[0]?1:-1 );
        
        int start=list.get(0)[0] , end= list.get(0)[1];
        
        for(int i=1; i<list.size() ; i++)
        {
            int temp[] = list.get(i);
            if(temp[0]<=end)
            {
                N--;
                start=temp[0];
                end = Math.min(end , temp[1]);
            }
            else
            {
                start = temp[0];   end=temp[1];
            }
        }
        return N;
    }
}
