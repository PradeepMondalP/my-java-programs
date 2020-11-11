
package regularexpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaRejexRelated {
    
    public static void main(String[] args) 
    {
        
       
      //  splitBasesOnDelimitter("pradeep1mondal2monday3tuesday4");
        
       maatching2();
     }
    
      public static void splitBasesOnDelimitter(String x)
      {
         
       // Specifies the string pattern which is to be searched 
        String delimiter =  "\\d"; 
        Pattern pattern = Pattern.compile(delimiter, 
                                        Pattern.CASE_INSENSITIVE); 
  
        // Used to perform case insensitive search of the string 
        String[] result = pattern.split(x); 
  
  
        for (String temp: result) 
            System.out.println(temp); 
      }
      
      
      public static void sampleCompileMethod() {
        
           Pattern p = Pattern.compile("Pradeep" ,Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher("pradeep mondal pradeep");
        
        while(m.find())
        {
            System.out.println("start = "+m.start() +" \t end = "+(m.end()-1));
        }
    }
      
      
      
      
      public static void matching()
      {
        
            System.out.println(Pattern.matches("\\d", "abc"));//false (non-digit)  
            System.out.println(Pattern.matches("\\d", "1"));//true (digit and comes once)  
            System.out.println(Pattern.matches("\\d*", "4443"));//false (digit but comes more than once)  
            System.out.println(Pattern.matches("\\d", "323abc"));//false (digit and char)    
            System.out.println("metacharacters D....");//D means non-digit  

            System.out.println(Pattern.matches("\\D", "abc"));//false (non-digit but comes more than once)  
            System.out.println(Pattern.matches("\\D", "1"));//false (digit)  
            System.out.println(Pattern.matches("\\D", "4443"));//false (digit)  
            System.out.println(Pattern.matches("\\D", "323abc"));//false (digit and char)  
            System.out.println(Pattern.matches("\\D", "m"));//true (non-digit and comes once)  

            System.out.println("metacharacters D with quantifier....");  
            System.out.println(Pattern.matches("\\D*", "mak"));//true (non-digit and may come 0 or more times)  
        }
      
      public static void maatching2()
        {
            System.out.println("? quantifier ....");  
            System.out.println(Pattern.matches("[amn]?", "a"));//true (a or m or n comes one time)  
            System.out.println(Pattern.matches("[amn]?", "aaa"));//false (a comes more than one time)  
            System.out.println(Pattern.matches("[amn]?", "aammmnn"));//false (a m and n comes more than one time)  
            System.out.println(Pattern.matches("[amn]?", "ammhht"));//false (a comes more than one time)  
            System.out.println(Pattern.matches("[amn]?", "am"));//false (a or m or n must come one time)  

            System.out.println("+ quantifier ....");  
            System.out.println(Pattern.matches("[amn]+", "a"));//true (a or m or n once or more times)  
            System.out.println(Pattern.matches("[amn]+", "aaa"));//true (a comes more than one time)  
            System.out.println(Pattern.matches("[amn]+", "aammmnn"));//true (a or m or n comes more than once)  
            System.out.println(Pattern.matches("[amn]+", "aazzta"));//false (z and t are not matching pattern)  

            System.out.println("* quantifier ....");  
            System.out.println(Pattern.matches("[amn]*", "ammmna"));//true (a or m or n may come zero or more times) 
           
        }
      
      
      public static void numberMatching() 
      {
          
      }
}
