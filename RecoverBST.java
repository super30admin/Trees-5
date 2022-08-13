/*
The following approach solves the problem using an inorder traveral of the BST. During the traversal,
whenever an incorrect location is found i.e the location where the swap happened, we note the locations
of the conflicting/incorrect nodes. In a single pass we are able to get the locations of both the incorrect
nodes, and we simply swap their values thereafter.

Did this code run on leetcode: Yes
*/
class Solution {
    TreeNode first;
    TreeNode second;
    TreeNode prev;
    //Time Complexity: O(n)
    //Space Complexity: O(h)
    public void recoverTree(TreeNode root) {
        
        if(root == null)
            return;
        
        inorder(root);
        
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    private void inorder(TreeNode root)
    {
        if(root == null)
            return;
        
        inorder(root.left);
        
        if(prev != null && prev.val >= root.val)
        {   //On the first conflicting location, we store the current and previous nodes. If there is no conflict
            //found in the rest of the traversal, then these locations are the only ones out of order, and we swap
            //values of these nodes.
            if(first == null)
            {
                first = prev;
                second = root;
            }
            //If we find a second conflicting location, we only store the current node, as in an ascending order
            //traversal, the location of the first conflicting value will already be in stored in the first pointer,
            //and the location of the second pointer will be the lesser value at the second conflict i.e the current node.
            else
                second = root;
        }
        
        prev = root;
        
        inorder(root.right);
    }
}