
package hackerrank;

import java.util.*;

class Node
{
    Map<Integer , Integer>child = new TreeMap<>();
    Node(int y , int x){
        child.put(y, x);
    }
}
       
public class QueenAttack2 {
    static Map<Integer , Node>map = new LinkedHashMap<>();
    static int N , i , j , count=0;
    
    public static void main(String ar[])
    {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int obs = sc.nextInt();

        i =N- sc.nextInt() +1 ;   // quuens position
        j = sc.nextInt();
        

        while(obs-- >0)
        {
            int x=N - sc.nextInt() +1;
            int y=sc.nextInt();
            if(map.containsKey(x)){
                Node obj = map.get(x);
                obj.child.put(y, x);
            }
            else
                map.put(x, new Node(y,x));
        }
        
        System.out.println("map "+ map);
        
        traverseMyChess();     
        
    }
    public static void traverseMyChess()
    {
        int x , row , col ;
            // leftSide....
         for( col=j-1 ; col>=1 ; col--)
            {
                if( isSafe(i,col))  count++;
                else break;
            }
          // rightSide... 
           for( col=j+1 ; col<=N ; col++)
            {
                if(isSafe(i,col))  count++;
                else break;
            }
           System.out.println("after right "+ count);

            // topSide.....  
        for( x=i-1 ; x>=1; x--)    
           {
                if(isSafe(x , j))   count++;
                else break;
           }
        System.out.println("after top "+ count);

           // bottomSide.....  
         for( x=i+1 ; x<=N; x++)    
           {
                if(isSafe(x , j))   count++;
                else break;
           }
         System.out.println("after bottom "+ count);

           // rightTop Diagnol
            row =i-1 ; col=j+1; 
           while(row>=1 ){
             if(isSafe(row-- , col++)) count++;
               else break;
           }
           System.out.println("ri8 TOP Dia "+ count);

            // leftDown diagnol
              row=i+1 ; col = j-1;                          
              while(row<=N ){
               if(isSafe(row++ , col--)) count++;
               else break;
           }
           System.out.println("left down Dia "+ count);
   

             // leftTop Diagonal
              row=i-1  ; col=j-1;
             while(row>=1 )
             {
               if(isSafe(row-- , col--)) count++;
                else break;
             }   
             System.out.println("left top Dia "+ count);

              //rightBottomDialgonal
              row=i+1  ; col=j+1;
             while(row<=N )
             {
               if(isSafe(row++ , col++)) count++;
                else break;
             }
             System.out.println("rigth bottom Dia "+ count);

             System.out.println(count);                      
    }

    public static boolean isSafe(int i ,int j)  // here 
    {
        if ( (i>=1 &&i<=N &&j>=1&&j<=N) )
        {
            if(map.containsKey(i)){
                if(!map.get(i).child.containsKey(j))
                    return true;
            }
            else 
                return true;
        }
        return false;
    }
}
