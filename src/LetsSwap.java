
import java.util.*;


public class LetsSwap {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        
        int ans=0 , min=1000009 , max=-10000009;
        for(int i=0;i<n ;i++)
        {
            arr[i]=sc.nextInt();
            --arr[i];
            ans+=Math.abs(i-arr[i]);
            
            int left=i , right=arr[i];
            if(left>right){
                    int temp=left;
                    left=right;
                    right=temp;
                 }
            min = Math.min(min, right);
            max = Math.max(max, left);
        }    
        if(max>min)   
            ans+=2*(max-min);
        
        System.out.println("answer "+ ans);
        
//        int ret=0;
//        for(int s :new int[]{1,-1})
//        {
//            for(int t : new int[]{1,-1})
//            {
//                int max1=(int)-1e9 ,max2=(int)-1e9;
//                for(int i=0; i<n ;i++)
//                {
//                    int s_arr_i=s*arr[i] ,t_i=t*i, t_arr_i=t*arr[i] , s_i=s*i   , abs_val=Math.abs(i-arr[i]);
//                    
//                    max1=Math.max(max1, s_arr_i - t_i - abs_val);
//                    max2=Math.max(max2, t_arr_i - s_i - abs_val);
//                }
//                ret = Math.max(ret, ans+max1+max2);
//            }
       // }
       // System.out.println(ret);
        
    }
}
