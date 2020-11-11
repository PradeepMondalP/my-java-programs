
package general;

interface Xyz
{
 void printMe();
}

public class InterfaceRelated implements Xyz{
    
    public static void main(String[] args) {
        
        
    }
    
    public static void hmm()
    {
       // Xyz obj = new Xyz(this);
    }

    @Override
    public void printMe() {
        System.out.println("hi");
    }
}
