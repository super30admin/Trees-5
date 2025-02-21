// TC: O(n)
// SC: O(1)

import java.util.ArrayList;
import java.util.List;

class LC94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        TreeNode temp = root;
        while (temp != null) {
            if (temp.left != null) {
                TreeNode l = temp.left;
                while (l.right != null && l.right != temp) {
                    l = l.right;
                }
                if (l.right == null) {
                    l.right = temp;
                    temp = temp.left;
                } else {
                    l.right = null;
                    ans.add(temp.val);
                    temp = temp.right;
                }
            } else {
                ans.add(temp.val);
                temp = temp.right;
            }
        }
        return ans;
    }
}