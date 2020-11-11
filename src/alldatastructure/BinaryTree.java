
package alldatastructure;

public class BinaryTree {
    
    static class Node
    {
        int data;
        Node left , right;

        public Node(int data) {
            this.data = data;
            left=right=null;
        }
    }
    static Node root;
    
    public Node createNode(int arr[],Node root , int index){
        
        if(index<arr.length)
        {
             Node temp = new Node(arr[index]);
             root = temp;
             
             root.left = createNode(arr, root.left, 2*index +1);
             root.right = createNode(arr, root.right, 2*index +2);
        }
        return root;
    }
    
    public void preOrder(Node s)
    {
        if(s==null)
             return;
        else
        {
            System.out.print("  "+ s.data);
            preOrder(s.left);
            preOrder(s.right);
        }
    }
    
    public static void main(String[] args) {
        
        int arr[] = {1,3,4,5,6,7,9};
        BinaryTree tree = new BinaryTree();
        tree.root = tree.createNode(arr, root, 0);
        
        tree.preOrder(root);
    }
}
