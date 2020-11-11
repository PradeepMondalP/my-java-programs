
package trees;

import constant.Node;
import constant.Node2;

public class BTFromPostandIn {

    static Node2 root;
    static int index;
    
    
    public static void main(String[] args) {
        
        int post[] ={9,1,2,12,7,5,3,11,4,8};
        int in[] =  {9,5,1,7,2,12,8,4,3,11};
        index = in.length-1;
        
        root = createTree(post, in, index, 0);
        
        System.out.println("in order");
        root.inOrderTraversal(root);
    }
    
    public static Node2 createTree(int post[] ,int in[] , int start , int end)  // start must be>end
    {
        if(start<end)
            return null;
        Node2 temp = new Node2(post[index--]);
        
        if(start==end)
             return  temp;
        
        
        int tempIndex = find(in , start , end , temp.data);
        
        temp.right = createTree(post, in, start, tempIndex+1);
        temp.left= createTree(post, in, tempIndex-1, end);
        
        return temp;
        
    }
    
      private static int find(int[] in, int start, int end , int val) { // start is bigger  , bcoz reverse traversing..
        int i;
        for(i =start ; i>=end ; i-- )
            if(in[i]==val)
                return i;
        return i;
            
    }
}
