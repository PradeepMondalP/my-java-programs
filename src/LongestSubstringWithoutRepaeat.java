
import java.util.*;


public class LongestSubstringWithoutRepaeat {
    
    public static void main (String[] args)
	 {
	   Scanner sc = new Scanner(System.in);
	   int t = sc.nextInt();
	   while(t-- >0)
	   {
	       String str = sc.next();
	       System.out.println(findLongestSubstring(str));
	   }
	 }
	 
	 static int findLongestSubstring(String str)
	 {
	     int start=0 , end=0 , n=str.length() , count=0;
	     int arr[] = new int[26];
	     
	     while(end < n )
	     {
                char c = str.charAt(end);
                if(arr[c-'a'] >0){
                    start = Math.max(start, arr[c-'a']);
                }
                arr[c-'a']=end+1;
                count= Math.max(count , end-start+1);
                end++;
	     }
	     return count;
	 }
}
