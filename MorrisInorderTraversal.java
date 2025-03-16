import java.util.ArrayList;
import java.util.List;

// TC-O(n) SC-O(h)
public class MorrisInorderTraversal {
    List<Integer> lst;
    public List<Integer> inorderTraversal(TreeNode root) {
        this.lst = new ArrayList<>();
        helper(root);
        return lst;
    }
    public void helper(TreeNode root) {
        if (root != null) {
            helper(root.left);
            lst.add(root.val);
            helper(root.right);
        }
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {
        }
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
