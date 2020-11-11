
package trees;

import constant.Node2;
import java.util.*;


public class CousinOfTree {
    
  
     static class MyClass
     {
         Node2 root;
         int lvl;
         public MyClass(Node2 root, int lvl) {
            this.root = root;
            this.lvl = lvl;
        }
     }
     
    static Node2 root;
    static int childCount=0 , val_1  , val_2;
    static List<MyClass>cls = new ArrayList<>();
    
    
    
    public static void check_cousin(Node2 root , int level)
    {       
         if(root==null)  return;
         if(root.left!=null && (root.left.data==val_1 || root.left.data==val_2) )
         {
             childCount++;
              System.out.println("......parent level is "+ level);
             cls.add(new MyClass(root, level+1));
         }
         if(root.right!=null && (root.right.data==val_1 || root.right.data==val_2) )
         {
             childCount++;
              System.out.println("......parent level is "+ level);
             cls.add(new MyClass(root, level+1));
         }
         check_cousin(root.left, level+1);
         check_cousin(root.right, level+1);
    }

    
    
    public static void main(String[] args) {
        
        root = new Node2(1);
        
        root.left = new Node2(2);
        root.left.right = new Node2(4);
       
        root.right = new Node2(3);
        root.right.right = new Node2(5);
        
        val_1=  5;
        val_2 = 4;
        
        check_cousin(root, 0);
        
        if(childCount<2 || childCount>2)
             System.out.println("false");
        
        int lvl_1 = cls.get(0).lvl;
        int lvl_2 = cls.get(1).lvl;
        int parent_1 = cls.get(0).root.data;
        int parent_2 = cls.get(1).root.data;
        
        if(childCount==2 && lvl_1==lvl_2 &&(parent_1!=parent_2))
            System.out.println("true");
          else
            System.out.println("else false");
    }
}
