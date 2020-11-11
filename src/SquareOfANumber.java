
import java.util.Scanner;


public class SquareOfANumber {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        System.out.println(isPerfectSquare(n));
    }

    static long findSquare(int n) {
        n = Math.abs(n);
        long sum=0;
        int temp = n;
        while(temp>0)
        {
            int pow=0;
            while(temp>=(1<<pow)) pow++;
            sum+=n<<(pow-1);
            temp-=1<<(pow-1);
        }
        return sum;
    }
    
    static boolean isPerfectSquare(int num)
    {
        long left = 2, right = num;
         
        while (left <= right) 
        {
            long mid = (left + right) / 2;
           if (mid * mid == num) 
            {
                return true; 
            }
            if (mid * mid < num) 
            { 
                left = mid + 1; 
            }
           else
            {
                right = mid - 1;
            }
        }
        return false;
    }      
            
}
