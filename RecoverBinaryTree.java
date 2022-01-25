// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We do inorder traversal
// We take prev node and compare it with root if the prev >= root 
// We can take it as abnormal node and put it to first
// In the next occurrence we put it to the second
// Then we swap first and second

class Solution {
    TreeNode first, prev, second;

    public void recoverTree(TreeNode root) {
        if (root == null)
            return;
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode root) {

        if (root == null)
            return;
        inorder(root.left);
        if (prev != null && prev.val >= root.val) {
            if (first == null) {
                first = prev;
                second = root;
            } else {
                second = root;
                return;
            }
        }
        prev = root;
        inorder(root.right);
    }
}

// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We do inorder traversal
// We take prev node and compare it with root if the prev >= root
// We can take it as abnormal node and put it to first
// In the next occurrence we put it to the second
// Then we swap first and second
// Same as previous but we use stack instead of recursion
class Solution {

    public void recoverTree(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> s = new Stack<>();
        TreeNode first = null, prev = null, second = null;
        while (root != null || !s.isEmpty()) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            if (prev != null && prev.val >= root.val) {
                if (first == null) {
                    first = prev;
                    second = root;
                } else {
                    second = root;
                    break;
                }

            }
            prev = root;
            root = root.right;
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;

    }

}