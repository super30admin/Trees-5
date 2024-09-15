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
class RecoverBST {
    
    // Time Complexity: O(n)    (where n -> no. of nodes in the tree)
    // Space Complexity: O(h)   (where h -> height of the tree)
    
    public void recoverTree(TreeNode root) {
        // Edge Case Checking
        if(root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        TreeNode x = null;
        TreeNode y = null;

        while(!stack.isEmpty() || root != null){
            // Do a pre-order traversal
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            
            // Assign appropriate values to x and y - where the nodes need to be swapped and are in incorrect order
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
    
    // Function to swap two nodes - just by value
    private void swap(TreeNode x, TreeNode y){
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }
}