
package general;

import java.util.Scanner;

public class Sir {
    public static void main(String[] args) {
        String s1, s2;
        int num1 , num2;
        
        Scanner obj = new Scanner(System.in);
        System.out.println("enter a string");
        s1 = obj.nextLine();
        System.out.println("enter astroh");
        s2 = obj.nextLine();
        System.out.println("enet nium");
        num1 = obj.nextInt();
        System.out.println("enetr anum");
        num2 = obj.nextInt();
        
        generatePassword(s1 , s2 , num1 , num2);
      
        
    }

    private static void generatePassword(String s1, String s2, int num1, int num2) {
        int indexNum ,x;
        String  longestString  , num11 , reverseString  , res="" ,finalResult;
        char lastIndexOfShorteststring;
        
        num11 = num1+"";  
        StringBuffer  obj = new StringBuffer(num11);
        
        x = s1.compareTo(s2);
        
        if(x>0)
        {
            
            longestString = s1;
            System.out.println("lonest string is "+s1);
            System.out.println("shortest String is "+s2);
            
            indexNum = s2.length();
            lastIndexOfShorteststring = s2.charAt(indexNum-1);
            
            finalResult =lastIndexOfShorteststring +longestString  +num11.charAt(num2-1) ;
            
            char y = obj.reverse().toString().trim().charAt(num2-1);
            
            finalResult= finalResult+y;
           
            System.out.println(finalResult);
            System.out.println(reverseString(finalResult ));
            
         }
       else
           {
               
                longestString = s2;
                System.out.println("lonest string "+s2);
                System.out.println("shortest String is "+s1);
            
              indexNum = s1.length();
              lastIndexOfShorteststring = s1.charAt(indexNum-1);
              finalResult =lastIndexOfShorteststring +longestString +num11.charAt(num2-1);
                    
              char y = obj.reverse().toString().trim().charAt(num2-1);
              finalResult= finalResult+y;
              
               System.out.println(finalResult);
                System.out.println(reverseString(finalResult ));  
       }
             
    }

    private static String reverseString(String finalResult) {
       
        char []myArray = finalResult.toCharArray();
        
        for(int i=0;i<myArray.length;i++)
        {
            if(Character.isAlphabetic(myArray[i]))
            {
                myArray[i] = Character.isUpperCase(myArray[i]) ?
                    Character.toLowerCase(myArray[i]) : Character.toUpperCase(myArray[i]);
            }
        }
        return new String(myArray);
    }
 
}
