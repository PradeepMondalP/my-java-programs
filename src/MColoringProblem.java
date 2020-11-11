import java.util.*;

public class MColoringProblem {
      static int V;
	public static void main (String[] args)
	 {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    while(t-- >0)
	    {
	        int m , e;
	        //found=false;
	        V=sc.nextInt();  m=sc.nextInt();  e=sc.nextInt();
	        
	        int graph[][] = new int[V][V];
	        int color[] = new int[V];
	        
	        for(int i=0 ; i<e ; i++)
	        {
                    int x=sc.nextInt(), y=sc.nextInt();
                    graph[x-1][y-1]=1;
                    graph[y-1][x-1]=1;
	        } 
	        
	       
	       
	        if(solve(graph , m  , color , 0)) 
	          System.out.println("1");
	        else  
	        System.out.println("0");
	    }
	 }
	 
	static boolean isSafe(int v, int graph[][], int color[],int c)
	{
		for (int i = 0; i < V; i++)
			if (graph[v][i] == 1 && c == color[i])
				return false;
		return true;
	}

	static boolean solve(int graph[][], int m,int color[], int v)
	{
		if (v == V)  return true;

		for (int c = 1; c <= m; c++) 
		{
			
			if (isSafe(v, graph, color, c))
			{
				color[v] = c;
				if (solve(graph, m,color, v + 1))
					return true;

				color[v] = 0;
			}
		}

		return false;
	}
}
