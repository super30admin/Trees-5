/*
 Algorithm: Iterative Inorder Traversal using an explicit stack

 Approach:
 - Use a stack to simulate recursion: push left children until null, then visit node and move to right child.
 - Continue while stack is not empty or current node is not null.
 - This yields the inorder (left, root, right) sequence.

 Time Complexity: O(n) where n is number of nodes (each node is pushed/popped at most once).
 Space Complexity: O(h) where h is tree height for the stack (worst-case O(n) for skewed tree).

 LeetCode: https://leetcode.com/problems/binary-tree-inorder-traversal/ (94)
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (!stack.isEmpty() || current!= null) {
            while (current!=null) {
                stack.add(current);
                current = current.left;
            }
            TreeNode treeNode = stack.pop();
            result.add(treeNode.val);
            current = treeNode.right;
        }
        return result;
    }


}
