
import java.util.*;


public class TALAZY {
    
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        long t =sc.nextLong();
        while(t-- >0)
        {
              long N=sc.nextLong() , B=sc.nextLong() , M=sc.nextLong() , time=0;

              while(N!=0)
              {
                    long subtract= N%2==0 ?N/2 :(N+1)/2;
                    time+=subtract*M;
                    N-=subtract;
                    if(N!=0)  time+=B;
                    M=M<<1;
              }
              System.out.println(time);
        }
    }
}

