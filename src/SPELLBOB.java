
import java.util.Scanner;


public class SPELLBOB {
    
    public static void main(String[] args)throws java.lang.Exception {
        
        Scanner sc = new Scanner (System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            String a=sc.next() , b = sc.next();
            if(solve(a,b) ) System.out.println("yes");
            else System.out.println("no");
        }
    }

    private static boolean solve(String a, String b) {
        
        char arr1[]= a.toCharArray() , arr2[]= b.toCharArray();
        
        if( (arr1[0]=='b' ||arr2[0]=='b') && (arr1[1]=='o' || 
                arr2[1]=='o') && (arr1[2]=='b'|| arr2[2]=='b') ) return true;
        
        if( (arr1[0]=='o' ||arr2[0]=='o') && (arr1[1]=='b' || 
                arr2[1]=='b') && (arr1[2]=='b'|| arr2[2]=='b') ) return true;
        
        if( (arr1[0]=='b' ||arr2[0]=='b') && (arr1[1]=='b' || 
                arr2[1]=='b') && (arr1[2]=='o'|| arr2[2]=='o') ) return true;
        
        return false;
    }

}
