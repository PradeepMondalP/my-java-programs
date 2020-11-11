
public class SearchInASorted2DMatrix {
  
    public static void main(String[] args) {
        
        int arr[][] ={ { 1, 3, 5, 7 }, 
                           { 10, 11, 16, 20 }, 
                           { 23, 30, 34, 50 } }; 
        
        
        
        System.out.println(searchMatrix(arr, 3));
        
        
    }
    
   static boolean searchMatrix(int[][] arr, int val)
    {
        int row=arr.length ;
        if(row==0 ) return false;
        
    
        int col=arr[0].length, start=0 , end=row-1 , reqPos=-1;
        if(col==0 ) return false;
        
        while(true)
        {
            if(Math.abs(start-end)==1 ||start==end)
            {
                reqPos=start;
                if(val > arr[reqPos][col-1])
                    reqPos++;
                break;
            }
            int mid=(start+end)/2;
            if(val>=arr[mid][0])  start=mid;
            else end=mid-1;
        }
        
        if(reqPos==-1 || reqPos>=row) return false;
        for(int i=0; i<col;i++)
            if(arr[reqPos][i]==val) return true;
        
        return false;
    }
    
     
    
}
