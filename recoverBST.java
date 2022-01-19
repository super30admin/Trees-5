// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We do an inorder traversal so that we get the numbers in ascending order, and we can find the anomoly when a number is out of order.
// We can implement this is either recursive or iterative way.

// recursive
 class Solution {
     TreeNode first, second, prev;
     public void recoverTree(TreeNode root) {
         if (root == null) return;
         inorder(root);
         int temp = first.val;
         first.val = second.val;
         second.val = temp;
     }

     private void inorder(TreeNode root) {
         if (root == null) return;

         inorder(root.left);
         if (prev != null && prev.val >= root.val) {
             if(first == null) {
                 first = prev;
                 second = root;
             }
             else {
                 second = root;
                 return;
             }
         }
         prev = root;

         inorder(root.right);
     }
 }

// Iterative
class Solution {
    public void recoverTree(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> st = new Stack<>();
        TreeNode prev=null, first=null, second=null;

        while (!st.isEmpty() || root != null) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }

            root = st.pop();
            if (prev != null && prev.val >= root.val) {
                if (first == null) {
                    first = prev;
                    second = root;
                }
                else {
                    second = root;
                    break;
                }
            }
            prev=root;

            root=root.right;
        }

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}