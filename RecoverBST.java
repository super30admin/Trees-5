// Time Complexity - O(n)
// Space Complexity - O(n)

// Two breaches => the values are in opposite subtrees
// One breach => parent and child value difference. 
// In both cases, an inorder traversal will give us the breaches that as the tree is expected to return results in sorted order.
// To solve the breaches, we need to keep a track of the breach using a flag. If the first breach occurs, flag sets to 1, first and last pointers are
// set to current node and previous node. If the breach occurs again, the last pointer is updated to the latest breach node.
class Solution {
    TreeNode first, last, prev;
    boolean flag;
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        inorder(root);
        int temp = first.val;
        first.val = last.val;
        last.val = temp;
    }
    
    private void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.left);
        if(prev!=null && prev.val >= root.val) { // breach
            if(!flag) {
                flag = true;
                first = prev; last = root;
            } else { // 2nd breach
                last = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
}