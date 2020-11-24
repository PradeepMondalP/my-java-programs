
public class AddMinCharToMakePalindrome {
    
    public static void main(String[] args) {
        String str = "ABC";
        System.out.println( solve2(str));
    }

    //TLE
    static int solve(String str) {
        if(str.length()==0 || str.length()==1) return 0;
        StringBuffer sb = new StringBuffer(str);
        if(str.equals(sb.reverse().toString() ) ) return 0;
        
        StringBuffer org = new StringBuffer() , temp;
        
        for(int i=str.length()-1 ; i>=1 ; i--)
        {
            org.append(str.charAt(i));
            temp = new StringBuffer(org);
            temp.append(str);
            sb = new StringBuffer(temp);
            temp.reverse();
            
            
            if( sb.toString().equals(temp.toString()) ) break;
        }
        return org.length();
    }
    
    //MEthod 2
    static int solve2 (String str)
    {
        int size= str.length() , j=size-1;
        
        for( ; j>=1 ; )
        {
            boolean found = true;
            int st = 0 ,end = j;
            while(st < end)
            {
                 if(str.charAt(st) != str.charAt(end)){
                     found = false;
                     break;
                 }
                 st++;  end--;
            }
            if(found) break;
            j--;
        }
        return size-j-1;
    }
}
