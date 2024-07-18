import java.util.ArrayList;
import java.util.List;

//Morris Traversal
class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        TreeNode curr = root;

        while(curr != null) {
            if(curr.left == null) {
                result.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode rightMost = curr.left;
                while(rightMost.right != null && rightMost.right != curr) {
                    rightMost = rightMost.right;
                }
                if(rightMost.right == null) {
                    rightMost.right = curr;
                    curr = curr.left;
                }
                if(rightMost.right == curr) {

                }
            }
        }

        return result;
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
