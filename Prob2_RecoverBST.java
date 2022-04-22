// Time Complexity : O(N)
// Space Complexity : O(H) ===== O(Log N base 2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class Solution {
    TreeNode firstNode;
    TreeNode secondNode;
    TreeNode prevNode;
    public void recoverTree(TreeNode root) {
        if(root == null)    return;
        helper(root);
        
        //Swapping values of 2 nodes which are swapped before in given BST
        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;
    }
    public void helper(TreeNode root){ // INORDER
        if(root == null)    return;
        
        
        helper(root.left);
        //St.pop() happened
        
        //Whenever breach is happening we are updating values of first and second Nodes
        if(prevNode != null && prevNode.val >= root.val){
            if(firstNode == null && secondNode == null){ // Very first time - violation of BST
                firstNode = prevNode;
                secondNode = root;
            }else{ // If another violation is there in Right subtree
                secondNode = root;
            }
        }
        
        prevNode = root; // UPDATE prevNode to root
        
        helper(root.right);
    }
}