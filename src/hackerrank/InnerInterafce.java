
package hackerrank;


public class InnerInterafce {

     public static void main( String[] args  )
     {
        
     Hmm obj = new Hmm ( )
     {
         @Override
         public void show() {
             System.out.println("haha  ->  Interface 1 -> show() ");
         }  
     };
     obj.show();
     
     Hmm.Hmm2  obj2 = new Hmm.Hmm2()
     {
         @Override
         public void display() {
             System.out.println("haha  ->  Interface 2 -> display () "); 
         }
         
     };
     obj2.display();
         
    }  
}


interface Hmm
{
    void show();
    
    interface Hmm2
    {
         void display(); 
    }
}
