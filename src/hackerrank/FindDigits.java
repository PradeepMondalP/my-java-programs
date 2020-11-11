
package hackerrank;

public class FindDigits {
    
    public static void main(String[] args) {
        System.out.println(findDigits(1012));
    }
    
    static int findDigits(int n) {
        int count=0 ,NUM=n;

        while(true)
        {
            int quot = NUM/10;
            int rem = NUM%10;
            System.out.println("q ="+ quot +"  rem "+ rem);
            
            if(rem==0) {
                NUM=quot;
                continue;
            }
            
            if(n%rem==0) count++;
            
            NUM=quot;
           if(NUM==0) break;
        }
        return count;
    }
}
