
package sample;

public class Max_sub_arr_of_3_ele {
    
    public static void main(String[] args) {
        
        System.out.println("max sub Array "+ max(-1,0,-3));
    }

    private static int max(int a, int b, int c) {
        
        int max=c;
        max = Math.max(Math.max(max, max+b) , Math.max(max, b));
        max = Math.max(Math.max(max, max+a), Math.max(max, a));
        return max;
    }
}
