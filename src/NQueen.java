
import java.util.*;


public class NQueen {
    
    static int N;
    static boolean found=false;
    public static void main(String[] args) {
        
        Scanner sc = new Scanner (System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            N = sc.nextInt();
            found=false;
            boolean [][]arr=new boolean[N][N];
            solve(arr , new Stack<Integer>() , 0);
            
            if(!found) System.out.println("-1");
            else System.out.println();
            
        }
     }

    private static boolean solve(boolean[][] arr,  Stack<Integer> list, int row) {
    
        //if(row>=4) return false;
        if(list.size()==N){
            found=true;
            List<Integer>temp = new ArrayList<>(list);
            
            System.out.print("[");
            for(int i=0 ; i<temp.size() ; i++)
            {
                System.out.print(temp.get(i)+" ");
            }
            
            System.out.print("]");
            return false;
        }
        for(int i=0 ; i<N ; i++)
        {
            boolean succes = isSafe(arr , row , i);
            if(succes)
            {
                arr[row][i]=true;
                list.push(i+1);
                solve(arr,  list, row+1);
                list.pop();
                arr[row][i]=false;
            }
            
        }
        return true;
    }

    static boolean isSafe(boolean[][] arr, int row, int col) {
       
        for(int i=0 ; i<row ; i++)  if(arr[i][col]) return false;
        
        for(int i=row,j=col ; i>=0&&j>=0 ; i--,j--) if(arr[i][j]) return false;
        
        for(int i=row,j=col ; i>=0&&j<N ; i--,j++) if(arr[i][j]) return false;
        
        return true;
        
        
        
        
        
        
    }
}
