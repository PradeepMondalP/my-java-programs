
import java.util.*;


public class FindValidMatrix {
    
    public static void main(String[] args) {
        
        int rSum[] = {3,8} , cSum[]= {4,7};
        int res[][] = restoreMatrix(rSum, cSum);
        
        
    }
    static  int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        
        int m=rowSum.length , n=colSum.length;
        int mat[][] = new int[m][n];
        
        Set<Integer>rSet = new HashSet<>() , cSet = new HashSet<>();
        
        while(rSet.size()!=m  &&  cSet.size()!=n)
        {
            int rI = findMinIndex(rowSum  , rSet) , cI=findMinIndex(colSum  , cSet) ;
            
            if(rowSum[rI]<colSum[cI])
            {
                mat[rI][cI]=rowSum[rI];
                colSum[cI]-=rowSum[rI];
                rSet.add(rI);
            }
            else{
                mat[rI][cI]=colSum[cI];
                rowSum[rI]-=colSum[cI];
                cSet.add(cI);
            }
        }
        return mat;
    }
    
    static int findMinIndex(int arr[] , Set<Integer>set)
    {
        int min=Integer.MAX_VALUE , ind=0;
        for(int i=0 ; i<arr.length ; i++){
            if(arr[i]<min && !set.contains(i)){
                min=arr[i];
                ind=i;
            }
        }
        return ind;
    }
}
