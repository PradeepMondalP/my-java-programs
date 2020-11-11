
package trees;

import constant.Node2;


// creating an AVL Tree
public class AVLTree {
    
    static Node2 root;
    
    public static void main(String[] args) {
        
        root = createTree(root, 14);
        root=createTree(root, 17);
        root=createTree(root, 11);
        root=createTree(root, 7);
        root=createTree(root, 53);
        root=createTree(root, 4);
        root=createTree(root, 13);
        root=createTree(root, 12);
        root=createTree(root, 8);
        root=createTree(root, 60);
        root=createTree(root, 19);
        root=createTree(root, 16);
        root=createTree(root, 20);
        
        System.out.println("pre order traversal");
        root.preOrderTraversal(root);
    }
    

    public static Node2 createTree (Node2 root , int key)
    {
         if(root==null)
             return new Node2(key);
         
         if(key > root.data)
             root.right = createTree(root.right, key);
         else
             if(key < root.data)
                 root.left = createTree(root.left, key);
         else
             {
                 System.out.println("already exists");
                 return root;
             }
         
         root.level = Math.max( height(root.left) , height(root.right) ) + 1 ;
         
         int balancedFactor = getBalancedFactor(root);
         
         if(balancedFactor > 1 && key<root.left.data)
              return  rightRotation(root);
         
         if(balancedFactor < -1 && key>root.right.data)
              return leftRotation(root);
         
         if(balancedFactor > 1 && key > root.left.data)
         {
             root.left = leftRotation(root.left);
             return rightRotation(root);
         }
         if(balancedFactor < -1 && key < root.right.data )
         {
              root.right  = rightRotation(root.right);
              return leftRotation(root);
         }
         return root;
    }
    
    public static int height(Node2 root)
    {
         if(root==null)
             return 0;
         return root.level;
    }

    private static int getBalancedFactor(Node2 root) {
         return height(root.left) - height(root.right);
    }

    private static Node2 rightRotation(Node2 y) {
        Node2 x = y.left;
        Node2 temp = x.right;
        
        x.right = y;
        y.left= temp;
        
        x.level = Math.max(height(x.left), height(x.right)) +1 ;
        y.level = Math.max(height(y.left) , height(y.right)) +1 ;
        
        return x;
    }

    private static Node2 leftRotation(Node2 x) {
        Node2 y = x.right;
        Node2 temp = y.left;
        
        y.left = x;
        x.right = temp;
        
        x.level = Math.max(height(x.left), height(x.right)) +1;
        y.level = Math.max(height(y.left) ,height(y.right))+1;
        
        return y;
    }
}
