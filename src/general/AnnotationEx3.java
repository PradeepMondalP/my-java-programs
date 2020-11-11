

package general;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD}) 
@interface Example
{
    int value() default 100;
    String name() default "Pradeep";
   
}


class MyExample
{
   
    @Example(value = 5000 , name = "Pradeep Mondal")
    public void hi()
    {
        System.out.println("hi macha");
    }
    
   
}



public class AnnotationEx3 {
    
    public static void main(String[] args) throws NoSuchMethodException {
        
        MyExample obj = new MyExample();
           Method mt =   obj.getClass().getMethod("hi");
           
           Example ex =  mt.getAnnotation(Example.class);
           
           System.out.println(ex.name() +"\n" +
           ex.value());
    }
}
