
package hackerrank;

import static java.lang.System.out;
import java.util.Scanner;
import java.util.Stack;

public class ParenthesisChecking {
    
    public static void main(String[] args) {
        
        Stack<Integer> stack = new Stack<>();
        System.out.println("Enter a String");
        Scanner sc = new Scanner(System.in);
        String str =sc.next();
        
        char []ch = str.trim().toCharArray();
        
        for(char c : ch)
        {
            int value = getValue(c);
            if(stack.isEmpty())
                 stack.push(value);
            else
            {
                 if(value%2==0)  //evem
                 {
                      int temp = value -1;
                      
                      if(stack.peek()==temp)
                          stack.pop();
                 }
                 else
                     stack.push(value);
                 
            }
            
        }
        
        if(stack.isEmpty())
            System.out.println("match");
        else
            System.out.println("no match");
        
        stack.clear();
    }
    
    public static int getValue(char c)
    {
        switch(c)
        {
            case '(' : return  1;
            case ')' : return  2;
            case '{' : return  3;
            case '}' : return  4;
            case '[' : return  5;
            case ']' : return  6;
        }
        return  0;
    }
   
}
