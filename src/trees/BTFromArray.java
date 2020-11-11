
package trees;

// creating a BT from a given  array

import constant.Node;
import constant.Node2;


public class BTFromArray {
    
    static Node root;
        
    public static void main(String[] args) {
        
        char arr[] = {'A' , 'B','C' , 'D' , 'E' , 'F' , 'G' , 'H'};
        root = insetLevelOrder(arr, root, 0 );
        root.preOrderTraversal(root);
        
        
    }
    
    public static Node insetLevelOrder(char arr[] , Node root, int index)
    {
          if(index < arr.length)
          {
              Node temp = new Node(arr[index]);
              root = temp;
              
              root.left =  insetLevelOrder(arr, root.left, 2*index+1);
              root.right = insetLevelOrder(arr, root.right, 2*index+2);
                     
          }
          return root;
    }
}
