// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Iterative soln:
class Solution {
    TreeNode first;
    TreeNode second;
    TreeNode prev; 
    boolean flag;
    public void recoverTree(TreeNode root) {
        if (root == null) return;
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    private void inorder(TreeNode root){
        Stack<TreeNode> st = new Stack<>();
        while(root != null || !st.isEmpty()){
            while(root != null){
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            if(prev != null && prev.val >= root.val){
                // violation
                if(!flag){
                    first = prev;
                    second = root;
                    flag = true;
                } else{ //second violation
                    second = root;
                }
            }
            prev = root;
            root = root.right;
        }
    }
}

// *******************************************

// Recursive soln:
class Solution {
    TreeNode first;
    TreeNode second;
    TreeNode prev; 
    boolean flag;
    public void recoverTree(TreeNode root) {
        if (root == null) return;
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    private void inorder(TreeNode root){
        //base
        if(root == null) return;
        //logic
        inorder(root.left);
        // st.pop();
        if(prev != null && prev.val >= root.val){
            // violation
            if(!flag){ // first violation
                first = prev;
                second = root;
                flag = true;
            } else{
                second = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
}