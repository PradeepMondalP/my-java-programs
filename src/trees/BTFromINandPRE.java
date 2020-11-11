
package trees;
import constant.Node;

// creating a binary tree using inorder and pre Order of the tree
public class BTFromINandPRE {
    
    static Node root;
    static int  index = 0;
    
    public static void main(String[] args) {
        
        char inOrder[] =  {'F','D','B','E','A','G','C','H'};
        char preOrder[] = {'A','B','D','F','E','C','G','H'};
        root = buildTree(inOrder, preOrder, 0, inOrder.length-1);
        
        root.inOrderTraversal(root);
    }
    
    public static Node buildTree(char inOrder[] , char []preOrder , int start , int end)
    {
        if(end<start)
            return null;
        
        Node temp = new Node(preOrder[index++]);
        if(start==end)
            return temp;
        
        int tempIndex = findIndex(inOrder , start , end , temp.data);
        
        temp.left  = buildTree(inOrder, preOrder, start, tempIndex-1);
        temp.right = buildTree(inOrder, preOrder, tempIndex+1, end);
        
        return temp;
    }

    private static int findIndex(char[] inOrder, int start, int end, char data) {
        
        int i;
        for(i = start ; i<=end ; i++)
              if(inOrder[i]==data)
                  return i;
        
        return i;
    }
}
