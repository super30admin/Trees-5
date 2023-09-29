//tc = O(n)
//sc= O (1)

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {

    public class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            inorderTraversal(root, result);
            return result;

        }

        private void inorderTraversal(TreeNode root, List<Integer> result) {
            if (node == null)
                return;
            // logic
            inorderTraversal(node, left);
            result.add(node.val);
            inorderTraversal(node, right);

        }
    }
}