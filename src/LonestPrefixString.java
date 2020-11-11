
import java.util.*;

public class LonestPrefixString {
    
        public String longestCommonPrefix(String[] arr) 
        {
            if(arr.length==0)  return "";
            int minLen=Integer.MAX_VALUE;
            for(String x :arr)
                 minLen= x.length()<minLen ? x.length() :minLen;
            
            StringBuilder str = new StringBuilder("");
            for(int i=0 ; i<minLen ; i++)
            {
                 boolean flag = true;
                 char temp='_';
                 for(int j=0 ; j<arr.length ; j++)
                 {
                      if(temp=='_'){
                          temp=arr[j].charAt(i);
                          continue;
                      }
                      else
                      {
                           if(arr[j].charAt(i) != temp){
                               flag=false;
                               break;
                           }
                      }
                 }
                 if(!flag)  break;
                 else{
                     str.append(temp);
                 }
            }
            
            return str.toString();
        }
}
