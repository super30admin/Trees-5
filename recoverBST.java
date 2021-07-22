// Time Complexity : O(N) N = number of nodes in the tree
// Space Complexity : O(H) Height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public void recoverTree(TreeNode root) {
        if(root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        TreeNode x = null;
        TreeNode y = null;

        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }

            TreeNode top = stack.pop();
            if(prev != null && prev.val > top.val){
                y = top;
                if(x != null)
                    break;
                x = prev;
            }

            prev = top;
            root = top.right;
        }
        swap(x,y);
    }

    private void swap(TreeNode x, TreeNode y){
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }
}
