import java.util.*;

public class GetMinElementFrmoStack {
    
    public static void main(String[] args) {
        
        
        
        
        Map<Integer  , Integer>map = new LinkedHashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.remove(1);
        map.put(1, 1);
        
        int fKey = map.entrySet().iterator().next().getKey();
        System.out.println(fKey);
        
        
        
        
        
//        Scanner sc = new Scanner(System.in);
//        int q = sc.nextInt();
//        GfG g = new GfG();
//        while(q-- >0)
//        {
//            int qt = sc.nextInt();
//            if(qt==1)  g.push(sc.nextInt());
//            else if(qt==2) System.out.print(g.pop()+" ");
//            else if(qt==3) System.out.print(g.getMin()+" ");
//        }
    }
}  


class GfG
{
    int minEle = Integer.MAX_VALUE  ,secMax=Integer.MAX_VALUE;
    Stack<Integer> stk = new Stack<>();

    /*returns min element from stack*/
    int getMin()
    {
	    if(stk.size()==0) return -1;
	    return minEle;
    }
    
    /*returns poped element from stack*/
    int pop()
    {
             int ret= -1;
	     if(stk.size()==0) return ret;
	     
	     if(minEle == stk.peek() )   ret = stk.pop();
	     else  return stk.pop();
	     
	     if(stk.size()==0){
	           minEle=Integer.MAX_VALUE;
	           secMax =Integer.MAX_VALUE;
	     }
	     else{
	           minEle = secMax; 
	       }
	     
	     return ret;
    }

    /*push element x into the stack*/
    void push(int x)
    {
        if(x < minEle)
        {
            secMax = minEle;
            minEle = x;
        }
	       
	    stk.push(x);
    }	
}

/*
4
87
SET 95 71 GET 16 SET 40 43 SET 99 64 GET 40 GET 14 SET 58 29 GET 72 GET 84 GET 26 SET 22 41 GET 27 GET 59 SET 53 57 SET 47 73 SET 84 12 SET 26 62 GET 17 SET 45 75 GET 31 SET 14 95 SET 61 20 GET 93 GET 77 SET 54 91 SET 99 96 SET 38 42 GET 77 GET 85 SET 1 84 GET 10 GET 41 SET 36 64 GET 74 GET 65 SET 50 52 SET 40 31 GET 66 GET 3 SET 92 80 SET 85 8 SET 20 62 SET 29 54 SET 20 95 SET 24 82 GET 88 SET 39 44 GET 95 GET 81 GET 87 GET 53 SET 96 99 GET 6 SET 67 43 GET 26 GET 79 SET 98 67 GET 48 GET 17 GET 13 SET 1 78 SET 33 98 SET 52 36 SET 50 99 GET 62 GET 35 SET 85 26 GET 98 SET 16 34 GET 82 GET 86 SET 98 1 GET 30 SET 80 14 GET 17 GET 86 SET 87 66 GET 27 GET 17 SET 53 70 SET 16 67 SET 29 34 GET 48 SET 1 27 GET 87 SET 1 64 GET 98


corect : 
-1 43 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1

*/