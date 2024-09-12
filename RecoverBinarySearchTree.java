package trees5;

import java.util.Stack;

public class RecoverBinarySearchTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	//Time Complexity : O(n), where n is the size of string s
	//Space Complexity : O(h), where h is the height of tree for recursion stack
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	TreeNode first;
    TreeNode second;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        if(root == null)
            return;
        
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    private void inorder(TreeNode root) {
        // base
        if(root == null)
            return;
        
        // logic
        inorder(root.left);
        if(prev != null && prev.val >= root.val) {
            if(first == null && second == null) {
                first = prev;
                second = root;
            } else
                second = root;
        }
        prev = root;
        inorder(root.right);
    }
    
    //Time Complexity : O(n), where n is the size of string s
  	//Space Complexity : O(n), for stack
  	//Did this code successfully run on Leetcode : Yes
  	//Any problem you faced while coding this : No
    TreeNode firs;
    TreeNode secon;
    TreeNode pre;
    public void recoverTree1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        
        while(!stack.isEmpty() || root != null) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            if(pre != null && pre.val >= root.val) {
                if(firs == null && secon == null) {
                    firs = pre;
                    secon = root;
                } else
                    secon = root;
            }
            pre = root;
            root = root.right;
        }
        
        int temp = firs.val;
        firs.val = secon.val;
        secon.val = temp;
    }
}
