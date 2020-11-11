
import java.util.*;


public class Knapsack {
    	public static void main (String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0)
		{
		    int N=sc.nextInt() , W = sc.nextInt();
		    int val[] = new int[N] , wt[]=new int[N];
		    
		    for(int i=0;i<N ; i++) val[i]=sc.nextInt();
		    for(int i=0;i<N ; i++) wt[i]=sc.nextInt();
		    
                    System.out.println(knapSack(W, wt, val, N));
		    
		}
	}

     static int knapSack(int W, int[] wt, int[] val, int n) {
        int i, w; 
        int K[][] = new int[n + 1][W + 1]; 
  
        // Build table K[][] in bottom up manner 
        for (i = 0; i <= n; i++) { 
            for (w = 0; w <= W; w++) { 
                if (i == 0 || w == 0) 
                    K[i][w] = 0; 
                else if (wt[i - 1] <= w) 
                    K[i][w] = Math.max( 
                        val[i - 1] + K[i - 1][w - wt[i - 1]], 
                        K[i - 1][w]); 
                else
                    K[i][w] = K[i - 1][w]; 
            } 
        } 
  
        return K[n][W]; 
    }
	
}
