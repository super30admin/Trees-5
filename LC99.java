// Recursive:
// Time Complexity: O(n)
// Space Complexity: O(h) h is the height of the tree

// Iterative:
// Time Complexity: O(n)
// Space Complexity: O(h) h is the height of the tree

import java.util.Stack;

public class LC99 {
    TreeNode first, second;
    TreeNode prev;

    // Recursive
    private void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        if(prev!=null && root.val<prev.val){
            if(first==null) first = prev;
            second = root;
        }
        prev = root;
        inorder(root.right);
    }
    private void swap(TreeNode i, TreeNode j){
        int t = i.val;
        i.val = j.val;
        j.val = t;
    }
    public void recoverTree(TreeNode root) {
        // inorder(root);

        // Iterative
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            TreeNode popped = stack.pop();
            if(prev!=null && popped.val<prev.val){
                if(first==null) first = prev;
                second = popped;
            }
            prev = popped;
            root = popped.right;
        }

        swap(first, second);
    }
}
