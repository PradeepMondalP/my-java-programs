
package trees;

import java.util.*;


// tree created  ....its Working  perfectly ....
public class SwappingNodes {
    
    static Set<Node>stack = new LinkedHashSet<>();
    static Node root;
    static List<Integer> list =
            Arrays.asList(2,3,-1,4,-1,5,-1,-1,-1,-1);
    
    //2,3,4,-1,5,-1,6,-1,7,8,-1,9,-1,-1,10,11,-1,-1,-1,-1,-1,-1
    static int MAX_LEVEL=0;

    
    static class Node
    {
        Node left , right;
        int level ,data ;
        
        Node( int data, int level) {
            this.data = data;
            this.level = level;
            left=null; right=null;
        }
    }
    
    
    public static void main(String[] args) {
        
        root = new Node(1,1);
        build(list);
        
        System.out.println("in order b4 calling \n");
        inOrder(root);
        
        exchangeTheNodes(2);
        
    }
    
   
    
    private static void exchangeTheNodes(int level) {
        
        int myNewLevel=level ,  i=1;
        Node temp;
        Queue<Node>que=new ArrayDeque<>();
        
       while(myNewLevel<=MAX_LEVEL)
       {
           que.add(root);
           
           while(!que.isEmpty())
           {
               temp= que.poll();
               if(temp.level > myNewLevel)   break;
               if(temp.level<myNewLevel)    //removed = from <=
               {
                   if(temp.left!=null)  que.add(temp.left);
                   if(temp.right!=null) que.add(temp.right);
               }
               if(temp.level==myNewLevel)
               {
                    swapLeftAndRightNodes(temp);
               }
           }
           
           que.clear();
           myNewLevel= level * ++i;
       }
       System.out.println("\n\n in order inside while \n");
       inOrder(root);
    }
    
     private static Node swapLeftAndRightNodes(Node temp) {
        if(temp.left==null && temp.right==null)  return temp;
        
        else if(temp.left!=null && temp.right!=null)
        {
            Node leftTemp = temp.left;
            temp.left =  temp.right;
            temp.right = leftTemp;
            
        }
       else if(temp.left==null)
        {
            temp.left = temp.right;
            temp.right=null;
        }
       else
        {
            temp.right = temp.left;
            temp.left=null;
        }
        
        return temp;
    }
    
    
    static void build(List<Integer>list)
    {
        for(int nodeData : list)
            root = createTree(root, nodeData);
    }
    
    static Node createTree(Node root , int data)
    {
        Queue<Node> que = new ArrayDeque<>();
        Node temp=null;
        
        que.add(root);
        
        while(!que.isEmpty())
        {           
            temp = que.poll();
            if(temp.data==-1)  continue;
            
            stack.add(temp);
            int parentNodeLevel = temp.level;
            if(parentNodeLevel >MAX_LEVEL)
                 MAX_LEVEL=parentNodeLevel;
            
            if(temp.left==null ) {
                  temp.left = new Node(data, parentNodeLevel+1);  break;
            }
            else
                 que.add(temp.left);
            
            if(temp.right==null){
                temp.right = new Node(data, parentNodeLevel+1);  break;
            }
            else
                 que.add(temp.right);
        }
        return root;
    }
    
    
    public static void levelOrderPrint(Node root)
    {
        if(root==null)   return;
        Queue<Node> que = new ArrayDeque<>();
        que.add(root);
        Node temp;
 
        while(!que.isEmpty())
        {
            temp =que.poll();
            System.out.print(" "+ temp.data);
            
            if(temp.left!=null)
                  que.add(temp.left);
            if(temp.right!=null)
                  que.add(temp.right);
        }
    }
    
    public static void postOrder(Node root)
    {
        if(root==null)  return;
        postOrder(root.left);
        postOrder(root.right);
        if(root.data==-1)  System.out.print("");
        else System.out.print(" "+ root.data);
    }
    
    public static void inOrder(Node root)
    {
        if(root==null)  return;
        inOrder(root.left);
         if(root.data==-1)  System.out.print("");
         else System.out.print(" "+ root.data);
        inOrder(root.right);
        
    }
}

/*
 it was inside the exchange function ..

LinkedList<Node> myList = levelArray[x];
           System.out.println("we have node in the consecutive level are" );
           
           for(Node rootX : myList)
           {
               System.out.print(rootX.data+" ");
           }
           
           System.out.println();
*/
