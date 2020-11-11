
package general;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


// user-defined annotation 
@Documented
@Retention(RetentionPolicy.RUNTIME) 
@ interface TestAnnotation 
{ 
    String Developer() default "Rahul";  
    String Expirydate() default "not over"; 
} // will be retained at runtime 
  

public class AnnotationExample2 {
    
    @TestAnnotation(Developer="Pradeep", Expirydate="01-10-2020") 
  static  void fun1() 
    { 
        System.out.println("Test method 1"); 
    } 
  
    @TestAnnotation(Developer="Anil", Expirydate="01-10-2021") 
  static  void fun2() 
    { 
        System.out.println("Test method 2"); 
    }
    
    public static void main(String[] args) {
         
        fun1();
        fun2();
    }
}
