// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

//Time Complexity : O(n) since we are traversing across all the nodes in the tree in worst case scenario
//Space Complexity: O(1) since we are not taking any extra space

class Solution {
    TreeNode prev; // Store the previous element
    TreeNode firstBreach; // Store the first breach
    TreeNode secondBreach; // Store the next breach
    boolean breached;
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        inOrder(root);
        //Swap the breaches
        int temp = firstBreach.val;
        firstBreach.val = secondBreach.val;
        secondBreach.val = temp;        
    }
    
    private void inOrder(TreeNode root)
    {
        //Base
        if(root == null) return;
        
        //Logic
        inOrder(root.left);
        if(prev != null && prev.val >= root.val) // Breach happened
        {
            if(!breached){ //First breach
                firstBreach = prev;
                secondBreach = root;
                breached = true;
            }
            else{ //Second breach
                secondBreach = root;
            }
        }
        prev = root;
        inOrder(root.right);
    }
}