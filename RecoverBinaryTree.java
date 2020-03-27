/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
Time Complexity: O(N) in the worse case we would be traversing the entire tree
Space Complexity: O(H) where is the height of the tree.
*/

class Solution {
    public void recoverTree(TreeNode root) {
        if(root ==null)
            return;
        TreeNode first = null, second =null;
        TreeNode prev =null, cur = root;
        Stack<TreeNode> st = new Stack<>();
        
        while(!st.isEmpty() || cur != null){
            //traverse left subtree.
            while(cur != null){
                st.push(cur);
                cur = cur.left;
            }
            cur = st.pop();
            // first node where predecessor is greater than current node.
           if(prev!= null && first == null && prev.val > cur.val)
              first = prev;
            // second node where predecessor is greater than current node.
           if(first!= null && prev.val > cur.val)
               second = cur;
           prev = cur;
           cur = cur.right;
        }
        //to recover the tree we just need to swap these two nodes.
        swap(first, second);
    }
    private void swap(TreeNode first, TreeNode second){
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}
