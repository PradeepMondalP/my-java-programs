
package hackerrank;


public class StrongPassword {
    
    public static int count(int n , String str)
    {
         int count=0;
        if(!str.matches(".*[a-z].*")) count++; 
        if(!str.matches(".*[A-Z].*")) count++; 
        if(!str.matches(".*[0-9].*")) count++; 
        if(!str.matches(".*[-!@#$%^&*()+].*")) count++;
        
        int diff=6-n;
        return Math.max(diff , count);
    }
    
    
}
