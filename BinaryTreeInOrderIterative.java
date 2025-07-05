// TC: O(n)
// SC: O(h)
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
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();

        while(!st.isEmpty() || root != null){
            // traverse till left most leaf and add to st
            while(root!= null){
                st.push(root);
                root = root.left;
            }
            // pop the left most leaf and add to result;
            root = st.pop();
            result.add(root.val);
            // go to right
            root = root.right;
        }

        return result;
    }
}