/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    List<Integer> re;

    public List<Integer> inorderTraversal(TreeNode root) {
        re = new ArrayList<>();
        // helper(root);
        helperMorris(root);
        return re;
    }

    //Tc: O(n)
    //Sc: O(n)
    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            helper(root.left);
        }

        re.add(root.val);

        if (root.right != null) {
            helper(root.right);
        }
    }

    //Tc: O(n)
    //Sc: O(1)
    private void helperMorris(TreeNode root) {
        TreeNode cur=root;
        while (cur != null) {
            if (cur.left==null) {//if there is no left element
                re.add(cur.val);
                cur =cur.right;
            }else{
                TreeNode prev = cur.left;
                while (prev.right !=null && prev.right != cur) {//if there exsit a right and the right is not pointing himself
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = cur;//create the thread
                    cur = cur.left;
                } else {
                    prev.right = null;  //cut the thread
                    re.add(cur.val);
                    cur = cur.right;
                }
            }
        }
    }
}