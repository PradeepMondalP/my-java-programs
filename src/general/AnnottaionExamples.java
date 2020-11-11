
package general;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)  
@Target(ElementType.METHOD)  
@interface MyAnnotation{  
int value() default 0;  
}  
  //Applying annotation  
class Hello{  
@MyAnnotation(value=1000)  

public void sayHello()
{System.out.println("hello berkather");}  
}

public class AnnottaionExamples  {
    
    public static void main(String[] args) throws NoSuchMethodException {
        
           Hello h = new Hello();
           Method m= h.getClass().getMethod("sayHello");  
  
                   
           MyAnnotation manno = m.getAnnotation(MyAnnotation.class);  
             System.out.println("value is: "+manno.value()); 
             
             
    
    }
}
