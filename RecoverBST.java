// Time: O(N) | Space: O(H)

class Solution {
    int breaches;
    TreeNode prev;
    TreeNode first;
    TreeNode second;
    public void recoverTree(TreeNode root) {
        helper(root);
        // once we find the mistake nodes,
        // we swap the values, but we don't swap the references,
        // breaches are guiding as to differentiate between the adjcent mistaken nodes and the mistake nodes at the difference places
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        return;
    }
    private void helper(TreeNode root) {
        if(root == null) return;
        helper(root.left);
        if(prev != null && prev.val > root.val) {
            breaches++;
            if(breaches == 1) {
                first = prev;
                second = root;
            } else {
                second = root;
            }
        }
        prev = root;
        helper(root.right);
    }
}