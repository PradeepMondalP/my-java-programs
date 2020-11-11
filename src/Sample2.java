import java.util.*;
public class Sample2 {
    
     static int n , found=0;
     static Set<Integer>set = new HashSet<>();
     static Stack<Integer>stk =new Stack<>();
   public static void main (String[] args) throws java.lang.Exception
	{
		try {
		      Scanner sc = new Scanner (System.in);
		      int t = sc.nextInt();
                      
		      while(t-->0)
		      {
                          long s = System.currentTimeMillis();
                            n=sc.nextInt();  found=0;
                            if(n==0 ||n==1 || (  (n&(n-1))==0) ){ // if (n==2^n)  then its not possbl
                                System.out.println("-1");  continue;
                            }
                            set.clear();    stk.clear();
                            backtrack();
		            if(found==0 ) System.out.println("-1");
                            
                            long ss = System.currentTimeMillis();
                          System.out.println("time "+(ss-s));
		      }
		      
		} catch(Exception e) {}
	}
	
   static void backtrack(  )
   {
        if(stk.size() ==n ){
            for(int x : stk)
                System.out.print(x+" ");
            System.out.println();
            found=1;  return;
        }   
        for(int i=1; i<=n ; i++)
         {
            if(set.contains(i)) continue;
            
            if(stk.size()==0)  solve(i);
            else{
                int prevEle = stk.peek();
                if( (i&prevEle)>0 )   solve(i);
            }
         }
    }
   
   static void solve(int i)
   {
       stk.push(i);    set.add(i);
        backtrack();
        if(stk.size()==n) return;
        stk.pop();  set.remove(i);
   }
    
}
