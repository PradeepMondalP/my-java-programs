
import java.util.Scanner;
import java.util.*;


public class PostfixExpressionEvaluation {
     public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        
         System.out.println(evaluatePostFix(str));
    }
     
      public static int evaluatePostFix(String str){
        
        Stack<Integer>stk = new Stack<>();
        int res=0;
        
        for(char c : str.toCharArray() )
        {
             if(c=='*' || c=='/' || c=='+' || c=='-')
             {
                 res  =solve( stk , c);
                 stk.push(res);
             }
             else 
                 stk.push( getValue(c) ); 
        }
        return stk.pop();
    }
    
    static int solve(Stack<Integer>stk , char c)
    {
        int small = stk.pop() , big = stk.pop();
        int res=0;
        switch(c)
        {
            case '+':res=big+small; break;
            case '-':res=big-small; break;
            case '*':res=big*small; break;
            case '/':res=big/small; break;
        }
        return res;
    }
    
    static int getValue(char c)
    {
        switch(c)
        {
            case '0': return 0; 
            case '1': return 1; 
            case '2': return 2; 
            case '3': return 3; 
            case '4': return 4; 
            case '5': return 5; 
            case '6': return 6;
            case '7': return 7; 
            case '8': return 8; 
            case '9': return 9; 
        }
        return -1;
    }
}
