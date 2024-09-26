// Time Complexity : O(n) where n is the number of nodes in the tree
// Space Complexity : O(n) where n is the number of recursive stack calls for inorder
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  Approach was challenging
/* Your code here along with comments explaining your approach: We will have two cases. If we have two breaches => the values are in opposite subtrees
or we have just a one breach where we have parent and child value difference. In either cases, an inorder traversal will give us the breaches that
are occuring while we are traversing the tree as the tree is expected to return results in sorted order but due to incorrect swaps, we will have breaches.
To solve the breaches, we need to keep a track of the breach using a flag. If the first breach occurs, flag sets to 1, first and last pointers are
set to current node and previous node. If the breach occurs again, the last pointer is updated to the latest breach node.
*/

// ITERATIVE
class Solution {
    TreeNode first = null;
    TreeNode last = null;
    public void recoverTree(TreeNode root) {
     if(root == null){return;}
     inorder(root);                                                         // Start the inorder traversal
    int temp = first.val;                                                           // Swap the first value node and last value node rectifying the breach
    first.val = last.val;
    last.val = temp; 
    }
    private void inorder(TreeNode root){
        Stack<TreeNode> stk = new Stack<>();
        TreeNode prev = null;
        int flag = 0;                                                                           // Indicate a breach
        while(root != null || !stk.isEmpty()){
            while(root != null){
                stk.push(root);
                root = root.left;                                                                   // Inorder traversal of left side
            }
            root = stk.pop();
            if(prev != null && prev.val > root.val){                                                // Previous value > current value is a breach
                    if(flag == 1){
                    last = root;                                                            // Second breach , update the last pointer
                    } else{ 
                    first = prev;                                                               // First breach, update first and last pointers
                    last = root;
                    flag = 1;                                                           // Set the flag to breach as 1
                    }
                }
                prev = root;                                                                    // Previous value tracker to the current node
                root = root.right;
        }
    }
}

// RECURSIVE
class Solution {
    TreeNode first = null;
    TreeNode last = null;                                                       // Global variables as we are doing recursive calls
    TreeNode prev = null;
    int flag = 0;
    public void recoverTree(TreeNode root) {
     if(root == null){return;}
     inorder(root);                                                                         // Start the inorder traversal
     int temp = first.val;
     first.val = last.val;                                                                      // Swap of first and last pointer nodes
     last.val = temp; 
    }
    private void inorder(TreeNode root){
        if(root == null){return;}
        inorder(root.left);                                                                 // left side traversal
        if(prev != null && prev.val > root.val){                                                // Breach has occured
                if(flag == 1){
                last = root;                                                                    // Second breach, update the last pointer
                } else{
                first = prev;
                last = root;                                                                    // Update the first and last pointers in first breach
                flag = 1;
                }
            }
            prev = root;                                                                        // Previous value tracker to current node
        inorder(root.right);                                                                // INorder traversa of right side
        }   
}