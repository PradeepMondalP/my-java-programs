// Knuth Morris algorithm

public class KMPAlgorithm {
    
    public static void main(String[] args) {
        
        String str = "ababcabcabababd" ,
              pat  = "ababd";
        //KMPAlgorith(str, pat);
        
       // System.out.println(longestPrefixSuffix("yycgicgyyycg"));
       
        //createArray("yycgicgyyycg");
    }
    
    static int[] longestPrefixSuffix(String str){
        int n=str.length();
        if(n<=1 ||str==null ) return null;
        
        int arr[] = new int[n+1];
        arr[0] = -1;
        int i=0 , j=-1;
        
        while(i < n)
        {
            if( j==-1 || str.charAt(i)==str.charAt(j))
                arr[++i] = ++j;
            else
                j = arr[j];
        }
        return arr;
    }
    
    public static void KMPAlgorith(String str , String pattern)
    {
        int patternArray[] = longestPrefixSuffix(pattern);
        int i=0 , j=-1;
        
        while (i < str.length())
        {
            if(str.charAt(i)== pattern.charAt(j+1)){
                i++;  j++;
            }
            else{
                if(j==-1) {
                    i++;
                    continue;
                }
                j = patternArray[j];
                //if(j==-1) i++;
            }
            
            if(j==pattern.length()-1){
                 System.out.println(" \nfound the pattern at " + (i-pattern.length()));
                 j= -1;
                 //i++;
            }
        }
    }
    
}
