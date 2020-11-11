
import java.util.*;


public class SmallestKMP {
    
    public static void main(String[] args) {
        
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       while(n-- >0)
       {
           String s = sc.next() , p=sc.next();
           System.out.println(".............");
           System.out.println(combineString(s, p));
       }
    }
    
   public static String combineString(String s , String p)
      {
        long sArr[] =new long[26] , sArr2[]=new long[26];
        StringBuilder sb = new StringBuilder() , sb2=new StringBuilder();

        for(int i=0;i<s.length();i++)  {sArr[s.charAt(i)-'a']++; sArr2[s.charAt(i)-'a']++;}
        for(int i=0;i<p.length();i++)  {sArr[p.charAt(i)-'a']--; sArr2[p.charAt(i)-'a']--;}
                
        int start , end=p.charAt(0)-'a';
         
        // adding   pre pattern alphabets  for both the string
         for(  start=0 ; start<=end ; start++){
              long extra = sArr[start] - p.charAt(start);
              while(extra-- >0)
               {
                 sb.append(  (char)(start+97) ) ;
                 sArr[start]--;
               }
              if(start<end)
              {
                   extra=sArr2[start]-p.charAt(start);
                   while(extra-->0)
                   {
                       sb2.append((char)(start+97));
                       sArr2[start]--;
                   }
              }
          }
         //  adding pattern alphabets
         sb.append(p);
         sb2.append(p);
        
         // adding   post pattern elemnts
         for(int i=0;i<26;i++){
             while(sArr[i]>0)
             {
                 sb.append( (char)(i+97) );
                 sArr[i]--;
             }
             while(sArr2[i]>0)
             {
                 sb2.append( (char)(i+97) );
                 sArr2[i]--;
             }
         }
         if(sb.toString().compareTo(sb2.toString()) >0) return sb2.toString();
         return sb.toString();
    }

}


/*

expected output.........


abohotypsu
aabadawyehhorst
aabadawyehhorst





*/