
package hackerrank;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;

public class Reflection {
    
    public static void main(String[] args){
            Class cls = new Studentt().getClass();
            Method[] methods = cls.getMethods();

            ArrayList<String> methodList = new ArrayList<>();
            for(Method meth : methods){
                methodList.add(meth.getName());
            }
            Collections.sort(methodList);
            
            for(String name: methodList){
                System.out.println(name);
            }
        }
}


class Studentt{
    private String name;
    private String id;
    private String email;

    public String getName() {
        return name;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void aa()
    {
        System.out.println("fd");
    }
}