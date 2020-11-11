
package hackerrank;

import java.util.Scanner;


public class FlippingBits {
    
    
    public static void main(String[] args) {
    
         Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[]  , len;
        char arr2[];
        

        while(n-- >0)
        {
            int  index=31;
            long x = sc.nextLong();
//            String str = Long.toBinaryString(x);
//
//            
//            arr= new int[32];
//            arr2 = str.toCharArray();
//            len = arr2.length-1;
//
//            for(int i=len ; i>=0 ; i--)
//                arr[index--]= arr2[i]-48;
//                
//           StringBuffer buff = new StringBuffer();    
//            for(int i=0 ; i<32; i++)
//               {
//                   if(arr[i]==1)
//                   {
//                       arr[i]=0;
//                       buff.append(0);
//                   }
//                   else   {
//                       arr[i]=1;
//                       buff.append(1);
//                   }
//
//               }
//               System.out.println(buff);
//
//             long res = Long.parseLong(buff.toString() , 2);
//             System.out.println("result :"+res);
        
            long num=(long)Math.pow(2, 32);
            System.out.println(num-x);

        }
    }
}
