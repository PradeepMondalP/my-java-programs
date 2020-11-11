package general;

import java.util.Scanner;

public class Www {

    public static void main(String[] args) {
     
        char[] ch;
        int startPoint=0 , endPoint =0 ,i;
        String str , capitalStr  , mainSum="";
        
        System.out.println("Enter a string");
        Scanner obj = new Scanner(System.in);
        str = obj.nextLine();
        capitalStr = str.toUpperCase() +" ";
        ch = capitalStr.toCharArray();
        
     for(i=0;i<capitalStr.length() ; i++)
        {
            if(ch[i]==' ')
            {
                endPoint = i;
                String tempString = capitalStr.substring(startPoint ,endPoint ).trim();
               // System.out.println("\nString is :" + tempString);
                startPoint = endPoint;
                
                mainSum = mainSum+(  getSum(tempString) );
            }
           
        }
        
        System.out.println(mainSum);
   
    }
    
    public static int getSum(String str)
    {
        char[] ch = str.toCharArray();
        int charLength = ch.length  ;
        int temp=charLength-1  , sum=0;

       for(int i =0; i<charLength ;i++)
        {
            if(i==temp)
            {
                 sum = sum +  (str.charAt(temp) - 64  );
                                                     //System.out.println(ch[i] + "  "+ ( (int)ch[i]  -64 ) )  ;
                 break;    
            }
            else{
                
                int x = ((int)ch[i]  -64 )    -     ( (int)ch[temp]  -64 );                
                                                    //  System.out.println(ch[i] +" val: " + ((int)ch[i] -64 ));
                                                   // System.out.println(ch[temp] +" val : " +((int)ch[temp] -64)  );     
                sum = sum + x ;
                temp = temp -1;
                
                if(i==temp)
                    break;      
            } 
          //  System.out.println((i +1) +" th time sum  is :" + sum);
        }
        
        return sum;
    }
}
