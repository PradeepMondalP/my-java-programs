
package trees;

import constant.Node2;


// creating a BST.. and insering the values (SEARCHING AND ADDING ELEMENTS)

//deleting a node    (SEARCHING A NODE AND DELETING IT..)


public class BST {
    
    static Node2 root;
    
    
    // creating BST
    public static Node2 create(Node2 root , int val)
    {
        if(root ==null)
        {
            Node2 obj = new Node2(val);
            root = obj;
            return root;
        }
        if(val > root.data)
              root.right = create(root.right, val);
        else
            if(val<root.data)
                root.left = create(root.left, val);
        else
                System.out.println("shaitaan");
        return root;
    }
    
    public static void main(String[] args) {
        
        root = create(root,10);
        create(root, 8);
        create(root, 15);
        create(root, 5);
        create(root, 9);
        create(root, 14);
        create(root, 20);
        
        preOrder(root);
        
 
        // delete nodes from here
    //    System.out.println("\n  after deletion 10  \n");
        delete(root, 20);
        System.out.println("\n after deleting 20");
        preOrder(root);
        
       
//        
       
        
    }
    
    
    // preOrder traversal
    public static void preOrder(Node2 root)
    {
        if(root==null)
            return;
        
        System.out.print(" "+ root.data);
        preOrder(root.left);
        
        preOrder(root.right);
    }
    
    
    //deleting a node from BST
    public static Node2 delete(Node2 root, int val)
    {
         if(root==null)
             return null;
         
         if(val< root.data)
              root.left= delete(root.left, val);
         else
             if(val> root.data)
                  root.right = delete(root.right, val);
             
             else //  we came to the required NOde..
             {
                  if(root.left==null)
                       return root.right;
                  if(root.right==null)
                      return root.left;
                  
                  // now , it came here that means root has two NOdes
                  // we have to replce the root NOde with inOrder Succesosr or precessor
                  root.data = inOrderSuccessor(root);
                  root.right= delete(root.right , root.data);
             }
         return root;
    }

    private static int inOrderSuccessor(Node2 root) {
        
        int val = root.data;
        while(root.left != null)
        {
            val = root.left.data;
            root = root.left;
        }
        return val;
    }
    
    
    
    
    //.......................................
    
   
    
}
