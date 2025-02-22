//99. Recover Binary Search Tree
//O(n)
//O(h)
class recoverBinarySearch {
    TreeNode prev, first, second;
    int cnt;

    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        return;
    }

    public void dfs(TreeNode root) {
        if (root == null || cnt == 2) {
            return;
        }
        dfs(root.left);
        if (prev != null && prev.val > root.val) {
            cnt++;
            if (first == null) { //if we see prev.val>root.val for 2nd time we will update second we need to keep first as it is
                first = prev;
            }
            second = root;
        }
        prev = root;
        dfs(root.right);
    }
}