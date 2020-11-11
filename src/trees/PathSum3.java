
package trees;
import java.util.*;

/**
 *You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 */



public class PathSum3 {
    
    public static void main(String[] args) {
       Set<Integer>set = new HashSet<>();
		set.add(1);
		set.add(2);
		
		Set<Integer>set2 = new HashSet<>(set);
		set2.add(3);
		for(int x : set2)
                {
                    set.add(x+10);
                    set.remove(x);
                    
                }
                
                System.out.println(set);
    }
}

class TreeNode{
    TreeNode left , right;
    int val;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(TreeNode left, TreeNode right, int val) {
        this.left = left;
        this.right = right;
        this.val = val;
    }
}


class Solution {
    
    int  count=0, SUM=0;
    Queue<MyClass>q = new ArrayDeque<>();
    MyClass myclassObj ;
    TreeNode temp , child;
    
    public int pathSum(TreeNode root, int ORG_sum)
    {
        if(root==null) return 0;
        SUM=ORG_sum;
        solve(root);
        return count;
    }
    public void solve(TreeNode root)
    {
        
        Set<Integer>set = new HashSet<>();
        set.add(root.val);
        q.add(new MyClass(root , set));
        
        while(!q.isEmpty())
        {
            myclassObj = q.poll();
            temp = myclassObj.root;
            
            if(temp.left!=null)
            {
                child=temp.left;
                set=validate(myclassObj , child);
                q.add( new MyClass (child , set));
            }
            if(temp.right!=null)
            {
                child=temp.right;
                set=validate(myclassObj , child);
                q.add( new MyClass (child , set));
            }
        }
    }
    
    public Set<Integer> validate(MyClass myclassObj , TreeNode child)
    {
        int curVal = child.val;
        Set<Integer>set = new HashSet<>(myclassObj.set);
        
        if(set.contains(SUM)){ set.remove(SUM);  count++; }
        
        set.add(curVal);
        
        for(int x : set)
        {
            set.add(x+curVal);
            set.remove(x);
        }
        return set;
        
    }
}

class MyClass
{
    Set< Integer>set=new HashSet<>() ;
    TreeNode root;
    MyClass(TreeNode r ,Set<Integer>m)
    {
        root=r;
        set.addAll(m);
    }
}
