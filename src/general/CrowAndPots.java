
package general;
import java.util.*;


public class CrowAndPots {
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
       
             for(int j =0 ; j<=tempList.size() ;j++)
            {
                int index = tempList.indexOf(MIN);
                int mull = MIN * (index+1);
                int fVal = tempList.get(0);
                
                if(fVal==mull)
                {
                    COUNT+=fVal;
                    break;
                }
                else if(fVal<mull){
                    COUNT+=fVal;
                    ascendingList.remove(ascendingList.indexOf(fVal));
                    descendingList.remove(descendingList.indexOf(fVal));
                    break;
                }
                else{
                    COUNT+=MIN;
                    tempList.remove(j);
                }
                        
            }
        }
        
        System.out.println( COUNT);
    }
    
}
