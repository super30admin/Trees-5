/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// TC - O(n)
// SC - O(1)
class RecoverBST {
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        TreeNode first = null;
        TreeNode second = null;
        TreeNode prev = null;
        Stack<TreeNode> st = new Stack<TreeNode>();
        while(!st.isEmpty() || root!= null) {
            while(root!= null) {
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            if(prev!= null && root.val <= prev.val) {
                //breach
                if(first == null) {
                    // first breach
                    first = prev;
                    second = root;
                } else {
                    second = root;
                    break;
                }
            }
            prev = root;
            root = root.right;
        }

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}