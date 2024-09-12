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
    public void recoverTree(TreeNode root) {
        if(root == null){
            return;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        
        TreeNode prev = null;
        TreeNode x = null;
        TreeNode y = null;
        
        //Doing inorder traversal
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            
            TreeNode top = stack.pop();
            //if prev > top then one pair where we get an element to be replaced
            //first pairs first element and second pairs second element nee to be swapped
            if(prev != null && prev.val > top.val){
                y = top;
                if(x != null){
                    break;
                }
                x = prev;
            }
            //every time keep track of prev node
            prev = top;
            root = top.right;
        }
        
        swap(x, y);
    }
    
    private void swap(TreeNode x, TreeNode y){
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }
}

//Time Complexity: O(n) n-> number of nodes
//Space Complexity: O(h) h-> height of the tree