
package gangsofwasypur;

import java.util.*;

// Souravs Code
public class ThreeSumUsingForLoop {
    
    public static void main(String[] args) {
        
        int n[] = {-1,0,1,2,-1,-4};
        Set<List> set = new LinkedHashSet<>();
        List<Integer> list ;
        int a,b,c;
        
        for(int i = 0;i<n.length-2 ; i++)
        {
            for(int j= i+1 ; j<n.length-1 ; j++)
            {
                for(int k = j+1 ; k<n.length; k++)
                {
                    a = n[i];    b=n[j];  c=n[k];
                    if(a+b+c ==0)
                    {
                        list = new ArrayList<>();
                        list.add(a);    list.add(b);   list.add(c);
                        Collections.sort(list);
                        set.add(new ArrayList(list));
                    }
                }
            }
        }
        System.out.println("the answer is  ..");
        for(List l : set)
            System.out.println("  "+ l);
    }
}


// output 1 = 
/*
[-1, 0, 1]
  [-5, 2, 3]


output 2= 
  [-1, 0, 1]
  [-1, -1, 2]
*/