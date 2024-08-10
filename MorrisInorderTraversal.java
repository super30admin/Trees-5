// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        while (root != null) {
            if (root.left == null) {
                result.add(root.val);
                root = root.right;
            } else {
                TreeNode pred = root.left;
                while (pred.right != null && pred.right != root)
                    pred = pred.right;
                if (pred.right == null) {
                    pred.right = root;
                    root = root.left;
                } else {
                    pred.right = null;
                    result.add(root.val);
                    root = root.right;
                }

            }

        }
        return result;
    }
}