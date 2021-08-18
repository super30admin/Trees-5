// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :



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

//Recover BST using no extra space
class Solution {
    //Have temp TreeNodes to keep track of nodes which are not at correct position
    //Two cases : 
    //1st - 2 nodes of same subtree are swapped (first and second are updated once) (set flag = true)
    //2nd - 2 nodes of different subtree are swapped (second in updates again (when flag = true))
    //To check if its valid/invalid, keep a prevNode, pointing to its left child
    //if no node is right leaf, prevNode points to parent
    //so in either case if prevNode >= curr root, then its invalid
    //so for 1st case, we swap prevnode and currroot
    // but if case 2 we sway prevNode with currroot (updated), so we update second to root
    //as if in different subtrees, prevNode will always > root (so we update second to root)
    TreeNode first; 
    TreeNode second; 
    TreeNode prevNode;
    boolean flag;
    public void recoverTree(TreeNode root) { 
        //if tree is empty, return null
        if(root == null) {
            return;
        }
        
        //else call helper method on root (inorder traversal : inorder traversal is ascending in valid BST)
        helper(root);
        
        //swap first and second
        int temp = second.val;
        second.val = first.val;
        first.val = temp; 
    }
    
    //helper method
    private void helper(TreeNode root) {
        //Base case 
        //if root == null, return the recursive call
        if(root == null) {
            return;
        }
        
        //call recursively on left node
        helper(root.left);
        //when root = null reached (st.pop takes place) 
        //left most node is on top of stack
        
        //we check if currroot is less that prevNode (if yes) (root is swapped here)
        //for first left node (prevnode = null) (so skip this step)
        //root may  be swapped with prevNode itself
        //so check flag value : if flag = flase
        //set first as prevNode and second as root
        //if flag = true, 2nd invalid node found, so set second to the currroot
        if(prevNode != null && prevNode.val >= root.val) {
            if(!flag) {
                first = prevNode;
                second = root;
                flag = true;
            }
            else {
                second = root;
            }
        }
        
        //upate prevNode to currRoot (to check validity of that subtree)
        prevNode = root;
        //call the right subtree (root is popped, so iterate on right side of tree)
        helper(root.right);
    }
}
