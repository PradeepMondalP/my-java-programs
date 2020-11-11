
import constant.Node2;
import java.util.*;


public class Rough {
    
    // creating BST
        static Node2 root;

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
        //topView(root);

    }
    
    
    public static void preOrder(Node2 root)
    {
        if(root==null)
            return;
        
        System.out.print(" "+ root.data);
        preOrder(root.left);
        preOrder(root.right);
        
    }
    

    //.........
     static class MyClass
    {
        public int data, index;
        MyClass(int x , int y){
            data= x ; index=y;
        }

        public int getIndex() {
            return index;
        }
    
    }

    static Set<MyClass> treeSet = new LinkedHashSet<>();
    static Set<Integer>indexSet = new HashSet<>();
    static Map<Integer, Integer> map = new LinkedHashMap<>();
   
	public static void topView(Node2 root) 
        {
      
            if(root==null)  return;
            
        

             addData(root , 0);

             for(Map.Entry entry : map.entrySet())
                         treeSet.add(new MyClass((int)entry.getKey() ,
                                 (int) entry.getValue()));

             
           treeSet.stream()
                   .sorted(Comparator.comparingInt(MyClass::getIndex))
                   .forEach(i-> System.out.print(i.data+" "));
    }

    public static void addData(Node2 root , int indexVal){
        if(root==null)  return;

        if(indexVal>0)
             map.put(root.data , indexVal);
        else{
              if(!indexSet.contains(indexVal)){
                  treeSet.add(new MyClass(root.data, indexVal) );
                  indexSet.add(indexVal);
              }             
        } 
        addData(root.left , indexVal-1);
        addData(root.right, indexVal+1);   
               
    }

}
