
import java.util.*;


public class Test {
    
    public static void main(String[] args) {
        
//        int arr[]={1000000000,1000000000,1000000000};
//        System.out.println(minSubarray(arr , 7));

       //  System.out.println(reorderSpaces("  hello"));
       
        int arr[][]={{-1,-2,-3},{-2,-3,-3},{-3,-3,-2}};
        
        System.out.println(maxProductPath(arr));
    }
    
    static int min =Integer.MAX_VALUE;
    
    public static int minSubarray(int[] arr, int p) {
        
        int sum=0 , n=arr.length , reqSUM=0,tempSum=0 , j=0,i=0;
        if(p==0 || n==0) return -1;
        
        for( i=0;i<n;i++)  {
            sum+=arr[i]%1000000009;
            sum%=1000000009;
        }
        
        if(sum<p) return -1;
        if(sum%p==0) return 0;
        
        reqSUM =sum%p;
         i=0;
        
        for( ; i<n; i++)
        {
            if(reqSUM==arr[i])  return 1;
            
            int temp = tempSum + arr[i];
            if(temp==reqSUM){
                min = Math.min(min , i-j+1 );
                temp-=arr[j++];
            }
            if(temp > reqSUM)
                temp-=arr[j++];
            
            tempSum=temp;
        }
        if(tempSum==reqSUM)
                min = Math.min(min ,i-j );
        return min;
    }
    
     public static String reorderSpaces(String text) {
        
        int spaceCount=0 , n=text.length();
        for(int i=0;i<n; i ++)  
            if(text.charAt(i)==' ' )  spaceCount++;
        
        String arr[] = text.split(" ");
        List<String>list = new ArrayList<>();
        for(String x : arr)
            if(x.length()>0) list.add(x);
        
        int totalWords = list.size() ;
        StringBuffer sb = new StringBuffer(); 
        
        if(totalWords==1){
            sb.append(list.get(0));
            for(int i=0;i<spaceCount;i++)  sb.append(" ");
            return sb.toString();
        }
        
        int centerSpaceReq = spaceCount/(totalWords-1) , extraSpace=spaceCount%(totalWords-1);
       
        
        for(int i=0;i<totalWords;i++)
        {
            sb.append(list.get(i));
            if(i==totalWords-1) break;
            for(int j=1; j<=centerSpaceReq ; j++)
                 sb.append(" ");
        }
        
        if(extraSpace>0)
            for(int j=1; j<=extraSpace ; j++)
                 sb.append(" ");
        
        return sb.toString();
    }
     
     static long rows,col;
     static  HashSet<Long> set = new HashSet<>();
     
     public static int maxProductPath(int[][] grid) {
         rows = grid.length;
         col = grid[0].length;
       
        dfs(grid,0, 0, 1);
        long max = -1;
        for (Long r : set) {
            max = Math.max(max, r);
        }
        if (max < 0) return -1;      
        long mod = (long)1e9 + 7;
        return (int)(max % mod);
    }
    private static void  dfs(int grid[][],int i, int j, long product) {
        if (i < 0 || i >= rows || j < 0 || j >= col) return;
        if (grid[i][j] == 0) {
            set.add((long)0);
            return;
        }
        if (i == rows - 1 && j == col - 1) {
            product *= grid[i][j];
            if (product > 0) set.add(product);
        }
        product *= grid[i][j];
        dfs(grid,i + 1, j , product);
        dfs(grid,i, j + 1, product);
    }
}
