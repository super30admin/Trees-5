// Time complexity: O(n)
// space complexity: O(1)
class Solution {
    List<Integer> result;
    public List<Integer> inorderTraversal(TreeNode root) {
        result = new ArrayList<>();
        inorder(root);
        return result;
    }
    private void inorder(TreeNode root) {

        if(root == null) return;

        inorder(root.left);
        result.add(root.val);
        inorder(root.right);
    }
}