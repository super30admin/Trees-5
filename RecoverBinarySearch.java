// Time Comeplexity : O(n) where n is the number of nodes in the tree
// Space Complexity : O(h) where h is the height of the tree

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
class RecoverBinarySearch {
    TreeNode prev;
    TreeNode first;
    TreeNode second;
    public void recoverTree(TreeNode root) {
        if(root == null){
            return;
        }
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode root){
        if(root == null){
            return;
        }

        inorder(root.left);

        if(prev != null && prev.val >= root.val){
            if(first == null){
                first = prev;
                second = root;
            }else{
                second = root;
            }
        }
        prev = root;

        inorder(root.right);
    }

    public void recoverTreeIterative(TreeNode root) {
        if(root == null){
            return;
        }

        TreeNode prev = null;
        TreeNode first = null;
        TreeNode second = null;
        Stack<TreeNode> st = new Stack<>();

        while(!st.isEmpty() || root != null){
            while(root != null){
                st.push(root);
                root = root.left;
            }
            root = st.pop();

            if(prev != null && prev.val >= root.val){
                if(first == null){
                    first = prev;
                    second = root;
                }else{
                    second = root;
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
