
import java.util.*;


public class Two2DMatrixMonana
{
    
    static int max = 0;
    static int x[] = { 0, 1, 1, 1, 0, -1, -1, -1 };
    static int y[] = { 1, 1, 0, -1, -1, -1, 0, 1 };
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) 
    {
        int row= sc.nextInt() , col = sc.nextInt();
        int arr[][] =new int[row][col];
        
        for(int i=0 ; i<row ;i++)
            for(int j=0 ; j<col ; j++)
                arr[i][j]=sc.nextInt();

        boolean visited[][] = new boolean[row][col];

        for (int i = 0; i < row; i++){
          for (int j = 0; j < col; j++){
             if (!visited[i][j])
                calculateMaxConnectedOnes(arr, visited, i, j);
            }
         }
       System.out.println(max);
    }

    static int calculateMaxConnectedOnes(int arr[][], boolean[][] visited, int row, int col)
    {
        if (visited[row][col] || arr[row][col] == 0)
            return 0;

        visited[row][col] = true;

        int tempSum = 0;

        for (int i = 0; i < 8; i++) {
            if (isValid(arr, visited, row + x[i],
                        col + y[i])) {
                tempSum += calculateMaxConnectedOnes(arr, visited, row + x[i], col + y[i]);
            }
        }
        max = Math.max(max, tempSum + 1);

        return tempSum + 1;
    }

    static boolean isValid(int[][] arr, boolean[][] visited,int row, int col)
    {
        return (row >= 0 && row < arr.length && col >= 0
                && col < arr[0].length && !visited[row][col]
                && arr[row][col] == 1);
    }
}

/*
5 5
1 0 0 0 1
0 1 0 1 0
0 0 1 0 1
0 1 0 0 0
1 1 1 1 1

6 7
0 0 0 0 0 0 0
0 1 0 0 0 0 1
0 0 1 0 0 1 0
1 0 0 1 0 1 0
1 1 0 0 1 0 0
0 0 0 0 0 0 0   

5 5
0 0 1 0 1
0 1 0 1 0
0 0 1 0 1
0 1 0 0 0
1 1 1 1 1


4 6
1 0 0 1 0 1
0 1 0 0 1 1
1 1 1 0 0 0
1 1 0 0 0 1

 4 4
0 1 1 0
1 1 1 1
1 1 1 1
1 1 0 0

2
6
0 0 0 1 1 1 
0 0 1 0 0 0

1 6
1 1 1 0 0 0 


4 4
0 1 1 1
0 0 1 1
0 1 1 0
0 1 1 0

5 5
1 1 1 0 0
0 1 1 0 0
0 0 0 0 1
1 0 0 1 1
1 1 0 0 1
*/


