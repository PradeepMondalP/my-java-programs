
package general;

// finding next closest palidrome number for a given number

public class FindingNextClosestPalindromeNum {
    
    public static void main(String[] args) {
        int n = 999;
        System.out.println( findNextPalindromeNumber(n));
    }
    
    private static int findNextPalindromeNumber(int n) {
        StringBuffer buff;
        int temp =0, ORIGINAL=n;
        while(true)
        {
            ORIGINAL++;
            buff= new StringBuffer(ORIGINAL+"");
            temp = Integer.parseInt(buff.reverse().toString().trim());
            if(ORIGINAL==temp)
                break;
        }
        return temp;
    }
}
