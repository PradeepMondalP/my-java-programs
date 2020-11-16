
public class ZAlgorithm {
    
  
    
    public static void search(String text, String pattern) 
    { 
  
        // Create concatenated string "P$T" 
        String concat = pattern + "$" + text; 
  
        int l = concat.length(); 
  
        int Z[] = new int[l]; 
  
        // Construct Z array 
        getZarr(concat, Z); 
  
        // now looping through Z array for matching condition 
        for(int i = 0; i < l; ++i){ 
  
            // if Z[i] (matched region) is equal to pattern 
            // length we got the pattern 
  
            if(Z[i] == pattern.length()){ 
                System.out.println("Pattern found at index "
                              + (i - pattern.length() - 1)); 
            } 
        } 
    } 
  
    // Fills Z array for given string str[] 
    private static void getZarr(String str, int[] Z) { 
  
        int n = str.length(); 
          
        // [L,R] make a window which matches with  
        // prefix of s 
        int L = 0, R = 0 , i=1; 
  
        while( i < n )
        {      
            if(i > R){ 
  
               L = R = i; 
               while(R < n &&  str.charAt(R - L)==str.charAt(R) ) 
                    R++; 
                  
                Z[i++] = R - L; 
                R--; 
            } 
            else{ 
                int k = i - L; 
  
                if( i+ Z[k] <=R) 
                    Z[i++] = Z[k]; 
  
                else{ 
                     R=-1;
                    } 
            } 
        } 
    }
    
      public static void main(String[] args) {
        String text = "dltfzotcjtnzxuglsdsmzcnockvfajfrmxoth"; 
        String pattern = "axojtctmnjdncvjhomzfnxzdjffsthcosftlu"; 
  
        search(text, pattern);
    }
}
