
package hackerrank;


public class AppendAndDelete {
    
    public static void main(String[] args) {
        
        String s = "123456789";
        String t = "12345";
        int x = 5;
        System.out.println(" "+ appendAndDelete(s, t, x));
    }
    
    static String appendAndDelete(String s, String t, int k) {
       
        if(s.equals(t)) return "yes";
        if(k<=0 && !(s.equals(t)))  return "No";
        
        if(solve(new StringBuffer(s) , new StringBuffer(t) , k)) return "Yes";
        else
            return "No";
    }
    
    public static boolean solve(StringBuffer s1 , StringBuffer s2 , int N)
    {
        int m = s1.length() , n = s2.length(), x , minShift , total_req=0;
        if(m>n){
             x = m-n;
            minShift = findMinPos(s1, s2 , n , m);
             total_req = 2*minShift + x;
            }
        else if(m<n){
             x = n-m;
             minShift = findMinPos(s1, s2 , m , n);
             total_req = 2*minShift + x;
            }
        else{
             minShift = findMinPos(s1, s2 , m , n);
             total_req = 2*minShift ;
            }
        if(total_req<=N) return true;
        return false;
    }

    // s=small size , l = large size
    private static int findMinPos(StringBuffer s1, StringBuffer s2 , int s , int l) {  
        int temp=s;
        for(int i=s-1 ; i>=0; i--)
            if(s1.charAt(i) != s2.charAt(i))
                temp=i;
        return s-temp;
    }
    
    
}
