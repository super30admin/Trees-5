package S30.Trees_5;


/* Recursive
Time Complexity : O(n)
Space Complexity : O(h) - recursive stack space
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/

/*Iterative
Time Complexity : O(n)
Space Complexity : O(h) - Stack space
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/

import java.util.Stack;

public class RecoverBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
      }
  }

    TreeNode prev;
    TreeNode first;
    TreeNode last;

    public void recoverTreeRecursive(TreeNode root) {

        if(root == null) return;
        inorder(root);
        int temp = first.val;
        first.val = last.val;
        last.val = temp;
    }

    private void inorder(TreeNode root){

        if(root == null) return;
        inorder(root.left);
        if(prev != null && prev.val >= root.val){

            if(first != null){
                last = root;
            }else{
                first = prev;
                last = root;
            }
        }
        prev = root;
        inorder(root.right);
    }

    public void recoverTreeIterative(TreeNode root) {

        if(root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(prev != null && prev.val >= root.val){

                if(first == null){
                    first = prev;
                    last = root;
                }else{
                    last = root;
                }
            }
            prev = root;
            root = root.right;

        }
        int temp = first.val;
        first.val = last.val;
        last.val = temp;
    }

}
