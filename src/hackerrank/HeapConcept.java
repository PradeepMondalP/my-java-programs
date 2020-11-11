
package hackerrank;
import java.util.*;


public class HeapConcept {
    
     public static void main(String ar[])
   {
       Scanner sc = new Scanner(System.in);
       int N = sc.nextInt();
       int K = sc.nextInt();
       PriorityQueue<Integer>que = new PriorityQueue<>(N);

       for(int i=0 ; i<N ;i++) que.add(sc.nextInt());
       long count=0 ;

       while(que.size()>1 && que.peek()<K)
       {
           int first = que.poll();
           int last =  que.poll();
           //System.out.println(first+2*last);
           que.add( first +2*last );
           count++;
       }
       //System.out.println("que "+ que);
       if(que.peek()< K)  System.out.println("-1");
       else System.out.println(count);
       
   }
}
