import java.util.*;

//Amortized Time Complexity: O(n) Worst Case O(n*h)
//Space complexity: O(1) since we are not using any extra space except for the result list which is auxiliary space.
//Intuition: The Morris Inorder Traversal algorithm uses the concept of threading the tree to avoid using a stack or recursion. 
// It modifies the tree structure temporarily to create links between nodes, 
// allowing us to traverse the tree in an inorder manner without additional space.

class MorrisInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                result.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode pre = curr.left;
                while (pre.right != null && pre.right != curr) {
                    pre = pre.right;
                }

                if (pre.right == null) {
                    pre.right = curr;
                    curr = curr.left;
                } else {
                    result.add(curr.val);
                    curr = curr.right;
                    pre.right = null;
                }
            }
        }

        return result;
    }
}
