/*
Time Complexity - O(n) where n is the number of nodes in the tree.
Space Complexity - O(h) where h is the height of the tree.
*/
class Solution {
    public void recoverTree(TreeNode root) {
        if(root == null)
            return;
        
        TreeNode param1 = null, param2 = null, prev = null;
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(prev != null && prev.val > root.val) {
                if(param1 == null)
                    param1 = prev;
                param2 = root;
            }
            prev = root;
            root = root.right;
        }

        int temp = param1.val;
        param1.val = param2.val;
        param2.val = temp;
    }
}
