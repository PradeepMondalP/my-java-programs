
package trees;

// function to check whether a tree is BST or Not..

import constant.Node2;


public class IsBST {
    
    public static void main(String[] args) {
         // ???????????//
    }
    
    static boolean  checkBST(Node2 root) {
        
        if(root==null)
              return true;
        
      if(root.left!=null && root.right!=null)
             return (leftSearch(root.left,root.data) && rightSearch(root.right,root.data));
      else 
        if(root.right!=null)
            return rightSearch(root.right,root.data);
       else
           return leftSearch(root.left , root.data);
          
    }

 static boolean leftSearch(Node2 root , int mainVal)
  {
      if(root==null)
            return true;
              
      boolean lVal=true , rVal=true;
      
      if(root.left!=null && root.right!=null)
          if(root.left.data >= root.data||root.right.data <= root.data || root.right.data>=mainVal  )
                {
                    lVal=false; rVal=false;
                }
       if(lVal && rVal)
      {
          lVal = leftSearch(root.left , mainVal);
          rVal = leftSearch(root.right , mainVal);
      }
      return (lVal && rVal);
  }

static boolean rightSearch(Node2 root , int mainVal)
{
    if(root==null)
            return true;

      boolean lVal=true , rVal=true;
    
     if(root.left!=null && root.right!=null)
         if( root.right.data <= root.data || root.left.data >= root.data || root.left.data<=mainVal  )
                {
                    lVal=false; rVal=false;
                }
     if(lVal && rVal)
      {
          lVal = rightSearch(root.left , mainVal);
          rVal = rightSearch(root.right , mainVal);
      }
      return (lVal && rVal);
  }
}
