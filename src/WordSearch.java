
//   latest code updated in LeetCode <word search>

public class WordSearch {
    
    
    
    public static void main(String[] args) {
        
        System.out.println(wordSearch());
    }

    private static boolean wordSearch() {
        
        for(int i=0; i<m ; i++)
            for(int j=0 ; j<n ; j++)
            {
                int arr[][] = new int[m][n];
                if(dfs(0 , i  , j , arr) )   
                    return true;
            }
        return false;
    }

    static char originArr[][]={
                                {'A','B','C','E'},
                                {'S','F','C','S'},
                                {'A','D','E','E'}
                              };
    static int  m=originArr.length , n=originArr[0].length;
    static String string="ABCCED";
    static int xArr[] = {1,0,0,-1};
    static int yArr[] = {0,1,-1,0};
    
    private static boolean dfs(int index, int i, int j, int[][] arr) {
       
          if(index>=string.length())  return true;
          
          if(i<0 || i>=m || j<0 || j>=n ) return false;
          if(originArr[i][j]!=string.charAt(index) || arr[i][j]==1) return false;
          
         System.out.println(originArr[i][j] +"  "+ string.charAt(index));
            arr[i][j]=1;
            for(int m=0;m<4;m++)
                 dfs(index+1 ,i+xArr[m] , j+yArr[m] , arr );
        
            arr[i][j]=0;
        return false;
    }
}
