
package trees;

import constant.Node2;


// finding the depth of the tree  (Binary tree)
// finding the min depth of a tree

public class DepthOfATree {
    
    static Node2 root;
    static int min = Integer.MAX_VALUE;
    
    public static void main(String[] args) {
        
        root=createBinaryTree(root, 10);
        createBinaryTree(root, 5);
        createBinaryTree(root, 12);
        createBinaryTree(root, 4);
        createBinaryTree(root, 15);
        
        createBinaryTree(root, 3);
        createBinaryTree(root, 2);
        createBinaryTree(root, 1);
       
        System.out.println("Inorder");
        inOrder(root);
        
        System.out.println(" \n  MAX depth of the tree");
        System.out.println("  "+ (maxDepth(root)-1) );
        
         
          minDepth(root, 0);
          System.out.println(" \n  MIN depth of the tree");
          System.out.println(min);
    }
    
    public static Node2 createBinaryTree(Node2 root , int val)
    {
         if(root==null)
         {
             root = new Node2(val);
             return root;
         }
         else
            if(val<root.data)
               root.left = createBinaryTree(root.left, val);
         else
             if(val> root.data)
               root.right = createBinaryTree(root.right, val);
         else
             System.out.println("root with that val already exists");
        
         return root;
    }
    
    public static void inOrder(Node2 root)
    {
        if(root==null)
            return ;
        
        inOrder(root.left);
        System.out.print(" "+ root.data);
        inOrder(root.right);
    }
    
      // maximum depth  of a tree
    public static int maxDepth(Node2 root)
    {
        if(root==null)
             return 0;
        
        int leftH = maxDepth(root.left);
        int rightH = maxDepth(root.right);
        
        if(leftH > rightH)     // means leftH is larger
            return leftH+1;
        return rightH+1;    // means rightH is larger 

    }  
    
    public static void minDepth(Node2 root , int lvl)
    {
        
        if(root==null)   return;
        root.level = lvl;
        if(root.left ==null && root.right==null)
        {
            System.out.println("we found a leaf");
            if(root.level < min)
                 min = root.level;
            return;
        }
        minDepth(root.left, root.level+1);
        minDepth(root.right, root.level+1);
    }
}
