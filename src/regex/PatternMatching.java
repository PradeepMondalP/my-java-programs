
package regex;


public class PatternMatching {
    
    public static void main(String[] args) {
        
        String str="abcdabcdabcdabcdefdc";
        System.out.println(isRepeatedPatternMatching(str));
    }
    
    public static boolean isRepeatedPatternMatching(String str)
    {
        int len = str.length();
    	for(int i=len/2 ; i>=1 ; i--) {
    		if(len%i == 0) {
    			int m = len/i;
    			String subS = str.substring(0,i);
    			int j;
    			for(j=1;j<m;j++) {
                            String sub = str.substring(j*i , i+j*i);
    				if(!subS.equals(sub)) break;
    			}
    			if(j==m)
    			    return true;
    		}
    	}
    	return false;
    }
}
