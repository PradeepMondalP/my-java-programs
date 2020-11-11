
package gangsofwasypur;

public class RecursiveFunctionToAddDigits {
    
    public static void main(String[] args) {
        
        int n = 123567;
        System.out.println("sum = "+ getSumFromRecursiveFunc(n));
    }

    private static String getSumFromRecursiveFunc(int n) {  // n=1235
        int val = n , sum=0;
        while(val>0)
        {
            int rem = val%10;
            sum+= rem;
            val = val/10;
        }
        return sum+"";
    }
}
