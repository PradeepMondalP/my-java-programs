
package general;

import java.util.Scanner;


public class NumberDiamond {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuffer buff;

        for(int i=1 ; i<=N ; i++)
        {
             for(int j=N ; j>i ; j--)  System.out.print(" ");
             buff = new StringBuffer();
             for(int k=i ; k>=1 ; k--){
                 buff.append(k);
                 System.out.print(k);
             }
             System.out.print(buff.reverse().toString()+"\n");
        }

        for(int i=N;i>=1;i--)
        {
            for(int j=i;j<N;j++)  System.out.print(" ");
            buff = new StringBuffer();
            for(int k=i;k>=1;k--){
                buff.append(k);
                System.out.print(k);
            }
            System.out.print(buff.reverse().toString()+"\n");
        }
    }
}
