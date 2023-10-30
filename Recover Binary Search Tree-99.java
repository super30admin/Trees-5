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
 //Time Complexity: O(n)
//Spce Complexity: O(h)
class Solution { 
    public void recoverTree(TreeNode root) {
        if(root == null){
            return;
        }
        TreeNode prev =null;
        TreeNode first = null;
        TreeNode second = null;
        Stack<TreeNode> s = new Stack<>();
        while(root != null || !s.isEmpty()){
            while(root != null){
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            if(prev != null && prev.val> root.val){
                if(first == null){
                    first = prev;
                }
                second = root;
            }
            prev = root;
            root =  root.right;
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}




