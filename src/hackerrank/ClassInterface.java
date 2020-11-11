
package hackerrank;

public class ClassInterface 
{
    
   static z  obj = new  z();
    public static void main(String[] args) {
        obj.msg();
    }
    
}

class x
{
    interface y
    {
        void msg ( ) ;
    }
}

class z implements x.y       
{

    @Override
    public void msg() {
        System.out.println("haaha");
    }
     
}