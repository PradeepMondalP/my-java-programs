
public class NthRootOfaNumber {
    public static void main(String[] args) {
        
        int N=3 , M=28;
        int res = find1byKthRoot(N , M);
        
        System.out.println( res);
        
      
    }
    
    
    //using Binary Search Method
  
    static int find1byKthRoot(int pow, int val) 
    {
        int low=1 , high=val , res=-1;
        
        while(low<=high)
        {
            int mid = (low+high)/2;
            int powerVal =(int) Math.pow(mid, pow);
            
            if(powerVal==val) return mid;
            
            if(powerVal >val) high=mid-1;
            else if(powerVal <val) low = mid+1;
        }
        
        return res;
    }
  

    
    // using newtons method
    static double find1BykthRoot(int N, int M) {
       double Xpre = Math.random()%10 , eps=0.0, delX=Integer.MAX_VALUE , xK=0.0;
       
       while(delX> eps)
       {
           xK = ( (N-1)*Xpre +(double)M/ Math.pow(Xpre, N-1)  )/(double)N;
           delX = Math.abs(xK - Xpre);
           Xpre = xK;
       }
       
       return xK;
    }
}
