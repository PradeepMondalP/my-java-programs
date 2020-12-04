
package simplePrograms;

public class SwapNibbles {
    
    public static void main(String[] args) {
        
        System.out.println(swapNibbles(19) );
    }
    
    static int swapNibbles(int N) {
        
        return (  (N & 0x0F)<<4 | (N & 0xF0)>>4 );
    }
}
