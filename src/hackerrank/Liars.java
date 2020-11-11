
package hackerrank;

import java.util.*;

public class Liars {
    
    private static final int MAX = 105;
    private static final int INF = Integer.MAX_VALUE;
    static int n;
    static int m;
    static int[] dis = new int[MAX];
    static boolean[] vis = new boolean[MAX];
    static HashMap<Integer,HashMap<Integer, Integer>> adj = new HashMap<>();
    
    
    public static void main(String[] args) {
        //File file = new File ("input.txt");
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m =  scanner.nextInt();
        for (int i = 0; i < m; i++) {
            int a, b, c;
            a = scanner.nextInt();
            b = scanner.nextInt();
            c =  scanner.nextInt();
            addEdge(a - 1, b, c);
            addEdge(b, a - 1, -c);
        }

        for (int i = 0; i < n; i++) {
            addEdge(i, i + 1, 1);
            addEdge(i + 1, i, 0);
        }

        int Lmin = -spfa(n, 0);
        int Lmax = spfa(0, n);
        System.out.println (Lmin + " " + Lmax);

        
    }
    public static void addEdge(int a, int b, int c){
        HashMap<Integer, Integer> temp = new HashMap<>();
        adj.putIfAbsent(a, temp);
        temp = adj.get(a);
        temp.put(b, c);
    }
    public static int spfa (int st, int ed){
        Arrays.fill(dis, MAX);
        Arrays.fill(vis, false);

        dis[st] = 0;
        vis[st] = true;
        ArrayList<Integer> queue = new ArrayList<>() ;

        queue.add(st);

        while (!queue.isEmpty()) {
            int u = queue.get(0);
            queue.remove(0);
            vis[u] = false;

            HashMap<Integer, Integer> temp =  adj.get(u);
            for (int v : temp.keySet()) {
                int tmp = dis[u] + temp.get(v);

                if (tmp < dis[v]) {
                    dis[v] = tmp;

                    if (!vis[v]) {
                        vis[v] = true;
                        queue.add(v);
                    }
                }
            }
        }

        return dis[ed];
    }
}


/*
8 2
1 5 3
3 6 2
3 6



4
1
1 3 2
*/