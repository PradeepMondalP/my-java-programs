
import java.util.*;


public class POSAND {
    
   public static void main (String[] args) throws java.lang.Exception
	{
		try {
		      Scanner sc = new Scanner (System.in);
		      int t = sc.nextInt();
		      while(t-->0)
		      {
                          long s = System.currentTimeMillis();
      	                  int n=sc.nextInt();
                          if(n==0 ||n==1 || (  (n&(n-1))==0) ){
                                System.out.println("-1");  continue;
                            }
      	                  List<Integer>list =new ArrayList();
                          Set<Integer>set=new HashSet<>();
                          boolean found=false;
                          
                          for(int i=1 ;i<=n ; i++)
                          {
                              list=new ArrayList<>();   list.add(i);
                              set= new HashSet<>();   set.add(i);
                              solve(n , i , list , set);
                              if(set.size()==n){
                                  found=true; break;
                              }
                          }
                          if(found)  {
                                for(int x : list)
                                    System.out.print(x+" ");
                                    
                               System.out.println();      
                          }
                              else System.out.println("-1");
                          
                          long ss = System.currentTimeMillis();
                          System.out.println("time "+(ss-s));
		            
		      }
		      
		} catch(Exception e) {}
	}
	
	static void solve(int n, int i, List<Integer> list, Set<Integer> set) {
         if(set.size() ==n || list.size()==n)   return;
             
         for(int x=1; x<=n ; x++)
         {
             if(set.contains(x))  continue;
             int prev = list.get(list.size()-1);
             
             if( (prev&x )>0 ){
                 list.add(x); set.add(x);
                 if(set.size()==n)   break;
                 solve(n, i, list, set);
                
               }
         }
         return;
    }
}

/*
//                if(list.size()==n) {
//                    System.out.println("list "+ list);
//                    found=1; break;
//                  }
*/
