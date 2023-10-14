/**
 Time Complexity - O(n) where n is the number of nodes in the tree root.
 Space Complexity - O(1) ignoring the space for storing the output.
  */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> result = new ArrayList<Integer>();

        TreeNode cur = root;
        while(cur != null) {

            if(cur.left == null) {
                result.add(cur.val);
                cur = cur.right;
            } else {
                TreeNode predecessor = cur.left;
                while(predecessor.right != null && predecessor.right != cur) {
                    predecessor = predecessor.right;
                } 
                if(predecessor.right == null) {
                    predecessor.right = cur;
                    cur = cur.left;
                } else {
                    result.add(cur.val);
                    predecessor.right = null;
                    cur = cur.right;
                }
            }
        }
        return result;
    }
}
