
import java.util.*;

public class MaxLengthChain {
    
    public static void main(String[] args) {
        
        int arr[][] = 
            { {30,60} , {15,28} , {27,40} , {50,90}, {5,24} };
        
        int count=1;
        List<int[]>pq = new ArrayList<>( );
        for(int x[] : arr) pq.add(x);
        
        Collections.sort( pq , (a,b)-> a[1]>b[1] ?1:-1  );
        
        int next=pq.get(0)[1];
        for(int i=1;i<pq.size() ; i++)
        {
            if(pq.get(i)[0]>next){
                count++;
                next=pq.get(i)[1];
            }
        }
        
        pq.forEach(i-> System.out.println(i[0] +" " + i[1]));
        
        System.out.println(count);
    }
}
