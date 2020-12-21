import java.util.*;

public class DEMTREE {
    
    static int[] S = new int[15];
    static int[] SS = new int[15];
    static boolean[][][] p = new boolean[11][15][15];
    static Vector<Vector<Integer>> adj = new Vector<Vector<Integer>>();
	 
	public static void main (String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int NSP = sc.nextInt();
		int Q = sc.nextInt();
		
		for (int i = 0; i <= N; i++) adj.add(new Vector<Integer>());	
                
		for (int i = 1; i < N; i++) {
			int v = sc.nextInt();
			adj.get(v).add(i + 1);
			adj.get(i + 1).add(v);
		}
                
		for (int i = 1; i <= N; i++) S[i] = sc.nextInt();
                
		for (int i = 1; i <= NSP; i++) {
			SS[i] = sc.nextInt();
			p[i][0][0] = true;
			dfs(i, SS[i], 0);
		}
		
		while (Q-- > 0) {
			int st = sc.nextInt();
			int tg = sc.nextInt();
			int W = sc.nextInt();
			
			int ans = 0;
			for (int i = 1; i <= NSP; i++) {
				for (int j = W; j > 0; j--) {
                                    if (p[i][st][j] && p[i][tg][j]) {
                                            ans = Math.max(ans, j);
                                            break;
                                    }
				}
			}
			System.out.println(2*ans);
		}
	}
	
	private static void dfs(int i, int j, int k)
	{
		for (int w = 0; w < 15; w++) {
			if (p[i][k][w]) {
				p[i][j][w] = true;
				if (w + S[j] < 15) 
                                    p[i][j][w + S[j]] = true;
			}
		}	
		for (int x : adj.get(j)) 
                    if (x != k) 
                        dfs(i, x, j);
	}
}


/*
7 1 5
1 1 2 2 3 3
3 5 4 2 7 9 1
1
2 3 10
1 1 10
2 1 10
4 5 10
4 7 10
*/