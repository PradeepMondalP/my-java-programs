
import java.util.*;



public class Sample {
    
    public static void main(String[] args) {
        
        
        
        String str = "geeksforgeeks";
        System.out.println(getMaxOccuringChar(str));
    }
    
     
    public static int getMaxOccuringChar(String s)
    {
        int arr[] = new int[26];
        int maxDistance=0 , startPos=0;
        for (int endPos=0; endPos<s.length(); endPos++)
        {
            if ( arr[s.charAt(endPos)-'a'] >0 )
                startPos = Math.max( startPos , arr[s.charAt(endPos)-'a']);
            
            arr[s.charAt(endPos)-'a']=endPos+1;
            maxDistance = Math.max(maxDistance,endPos-startPos+1);
        }
        return maxDistance;
    }      
      
}
