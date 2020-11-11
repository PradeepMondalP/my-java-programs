
package hackerrank;

import java.util.*;

// not completed/...

public class BricksGame {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- >0)
        {
            int size = sc.nextInt();
            int arr[] = new int[size];
            
            for(int i=0 ; i<size ;i++)
                arr[i]=sc.nextInt();
            
            long max=arr[0] , temp=arr[0] , nextPos=0;
            for(int i=0 ; i<=size ; )
            {
                if(i+2<size && temp+arr[i+1]+arr[i+2] >max)
                {
                    nextPos=i+2+4;
                    temp=temp+arr[i+1]+arr[i+2];
                }
                if( i+1<size && max+arr[i+1] > temp)
                {
                    nextPos=i+1+4;
                    temp=max+arr[i+1];
                }
                if(max > temp)
                {
                    temp=max;
                    nextPos=i+4;
                }
                if(i+4<size && max + arr[i+4]>temp)
                {
                    temp=max+arr[i+4];
                    nextPos=i+4;
                }
                i+=nextPos;
                max =temp;
             
            }
            
            System.out.println("max val "+ max);
        }
    }
}

/*
2
5
999 1 1 1 0
5
0 1 1 1 999


1001
999

1
10
1 3 4 2 7 5 8 9 1 4  
                     26



2
5
999 1 1 1 0
5
0 1 1 1 999

1001
999




3
5
123 4 56 19 20
5
15 17 25 128 95
5
15 17 19 10 100

183
110
115




3
10
321 386 740 595 161 176 606 64 577 316
10
267 744 264 372 943 683 506 607 504 441
10
3 559 416 40 263 747 634 135 817 34

2293
2892
2494
*/