
package general;

import java.util.*;

//  crow an pot competitive problem

public class NumberMatrix {
    
    public static int COUNT=0;
    public static short K;
    static ArrayList<Integer> ascendingList = new ArrayList();
    static ArrayList<Integer> descendingList = new ArrayList();
    
    public static void main(String[] args) {
        
       Scanner sc = new Scanner(System.in);
        short N = sc.nextShort();
         if(N<=0 )
           {
            System.out.println("-1");
            System.exit(0);
           }
        
        for(int i = 0 ; i<N ;i++)
            ascendingList.add(sc.nextInt());
            
        K = sc.nextShort();

         if(K<=0 || K>N)
        {
            System.out.println("-1");
            System.exit(0);
        }
         
        Collections.sort(ascendingList);
        descendingList.addAll(ascendingList);
        Collections.reverse(descendingList);
          
        for(int i = 0 ; i<K ;i++)
        {
            ArrayList<Integer>tempList = new ArrayList(descendingList);
            System.out.println("temp List "+ tempList);
            int MIN = ascendingList.get(0);
       //     System.out.println("min "+ MIN);
            
            for(int j =0 ; j<=tempList.size() ;j++)
            {
          //      System.out.println("j===>"+ j);
                int index = tempList.indexOf(MIN);
            //    System.out.println("index = "+ index);
                int mull = MIN * (index+1);
            //    System.out.println("mul = "+ mull);
                int fVal = tempList.get(0);
                
                if(fVal==mull)
                {
                //    System.out.println("fval == mull");
                    COUNT+=fVal;
                    break;
                }
                else if(fVal<mull){
                 //   System.out.println("fval < mull");
                    COUNT+=fVal;
                    ascendingList.remove(ascendingList.indexOf(fVal));
                    descendingList.remove(descendingList.indexOf(fVal));
                    break;
                }
                else{
              //      System.out.println("fval > mull");
                    COUNT+=MIN;
                    tempList.remove(j);
                }
                        
            }
        }
        
        System.out.println( COUNT);
    }
}

