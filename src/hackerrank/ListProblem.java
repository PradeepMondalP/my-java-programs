
package hackerrank;

import java.util.LinkedList;
import java.util.Scanner;


public class ListProblem {
    
    public static void main(String[] args) {
        
        LinkedList<Integer> list  = new LinkedList();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        for(int  i =  0  ; i <N ; i++)
             list.add(sc.nextInt());
        
        int Q = sc.nextInt();
        sc.nextLine();
        
        for(int i = 0 ; i<Q ; i++)
        {
             String query = sc.nextLine();
             if(query.equals("Insert"))
             {
                  int x = sc.nextInt();
                  int y = sc.nextInt();
                  list.add(x, y);
                  System.out.println("ater adding "+ list);
             }
             else
             {
                  int index = sc.nextInt();
//                  int m = list.get(x);
//                   System.out.println("elemnt at "+ x +"= "+ m);
                   list.remove(index);
                //   System.out.println("aftre removing "+ list);
                
             }
             sc.nextLine();
        }
        System.out.println(list.toString().replace("[", "").replace("]", "").replace(",",""));
        
    }
    
    public static void main2(String[] args) {
        /* Create and fill Linked List of Integers */
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            int value = scan.nextInt();
            list.add(value);
        }
        
        /* Perfrom queries on Linked List */
        int Q = scan.nextInt();
        for (int i = 0; i < Q; i++) {
            String action = scan.next();
            if (action.equals("Insert")) {
                int index = scan.nextInt();
                int value = scan.nextInt();
                list.add(index, value);
            } else { // "Delete"
                int index = scan.nextInt();
                list.remove(index);
            }
        }
        scan.close();
        
        /* Print our updated Linked List */
        for (Integer num : list) {
            System.out.print(num + " ");
        }
}

}