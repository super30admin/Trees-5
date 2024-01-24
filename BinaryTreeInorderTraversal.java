
// TC : O(n)
// SC : O(h)

package S30_Codes.Trees_5;

import java.util.ArrayList;
import java.util.List;

class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> lst = new ArrayList<>();

        inorderTraversal(root, lst);
        return lst;
    }

    public void inorderTraversal(TreeNode root, List<Integer> lst) {
        if(root == null)
            return;

        inorderTraversal(root.left, lst);
        lst.add(root.val);
        inorderTraversal(root.right, lst);
    }
}