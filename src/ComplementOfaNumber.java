
public class ComplementOfaNumber {

    public static void main(String[] args) {
        int N=5;
        
       // System.out.println((4&5));
        System.out.println(solve(N));
    }

    private static int solve(int N) {
        if(N==0) return 1;
        int msb=0 , res=0;
        for(int i=31;i>=0 ; i--)
        {
            if( (N& (1<<i)) == (1<<i)) {
                msb=i;  break;
            }
        }
        for(int i=msb ; i>=0 ; i--)
            res|=(1<<i);
        return N^res;
    }
    
}

