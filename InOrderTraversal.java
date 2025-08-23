/****
 * Performs an inorder traversal of a binary tree recursively.
 * Visits left subtree, processes the root, and then visits the right subtree.
 * Returns a list of node values in inorder sequence.
 */
 
// Time Complexity: O(N), where N is the number of nodes in the tree
// Space Complexity: O(H), where H is the height of the tree (recursion stack)
public class InOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        helper(root,result);
        return result;
    }
    
    public void helper(TreeNode root, List<Integer> result) {
        if(root == null) {
            return;
        }
        
        helper(root.left,result);
        result.add(root.val);
        helper(root.right,result);
    }    
}
