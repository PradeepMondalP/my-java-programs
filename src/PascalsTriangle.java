
import java.util.*;


public class PascalsTriangle {
    
    public static void main(String[] args) {
        
        System.out.println(generate(5));
    }
    static List<List<Integer>> generate(int n)
    {
        
        List<List<Integer>>res = new ArrayList<>();
        
        for(int i=1 ; i<=n ; i++)
        {
            List<Integer>list = new ArrayList<>();
            for(int j=0 ; j<i ; j++)
            {
                if(j==0 || j==i-1 )
                {
                    list.add(1);
                }
                else
                {
                    int a=res.get(i-2).get(j-1);
                    int b=res.get(i-2).get(j);
                    list.add(a+b);    
                }
            }
            res.add(list);
        }
        
        return res;
    }
}
