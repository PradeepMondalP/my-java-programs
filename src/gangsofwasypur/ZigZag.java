
package gangsofwasypur;

public class ZigZag {
    
    public static void main(String[] args) {
      StringBuilder str = new StringBuilder("PAYPALISHIRING");
        int n1 , n=4;
        
        
       for(int x = 0 ; x< 2  ; x++)
       {
            for(int i = 0 ; i<5 ; i++)
            System.out.print(i+" "+"\n");
            
           for(int i = 0 ; i<5 ; i++)
            System.out.print(i+" "+"\n");
       }
        
    }
    
    public static void printZigZag(StringBuilder str , int n)
    {
        int n1;
        while(str.length()>0)
        {
             if(str.length()-n <0)
             {
                 System.out.print(str.charAt(0) + "\n" );
                 str.deleteCharAt(0);
             }
             else if(str.length()-n >0)
             {
                for(int i = 0 ; i<n ; i++)
                {
                    System.out.print(str.charAt(0) + "\n" );
                    str.deleteCharAt(0);
                }
                 n1 = n/2;
                while(n1>0)
                {
                     for(int i = 0 ; i<n1 ; i++)
                         System.out.print("\n");
                     System.out.println(str.charAt(0));
                     str.deleteCharAt(0);
                     n1--;
                }
                
             }
            
        }
    }
}
