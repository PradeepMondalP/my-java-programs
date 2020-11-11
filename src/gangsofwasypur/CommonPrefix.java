package gangsofwasypur;
// finding common prefix...
import java.util.ArrayList;
import java.util.List;
public class CommonPrefix {
    
    public static void main(String[] args) {
        List<String>list = new ArrayList<>();
        list.add("dog");
        list.add("reacecar");
        list.add("car");
        list.add("fluoght");        
        char [] arr = findLongestPrefix(list);
        for(char x : arr)
            System.out.print(x+" ");
    }
    private static char[] findLongestPrefix(List<String> list) {
      StringBuffer string=new StringBuffer();
      String str= list.get(0);
               for(int i= 0 ; i<str.length() ; i++){
                   boolean vis = true;
                   char c1 = str.charAt(i);
                   for(int j = 1 ; j<list.size();j++)
                   {
                       try{
                           char c2 = list.get(j).charAt(i);
                           if(c1!=c2){
                           vis=false;
                           break;
                                    }
                       }
                       catch(Exception e){
                           return string.toString().toCharArray();  }
                   }
                   if(vis)
                       string.append(c1);
               }
            return string.toString().toCharArray();
      }
}
