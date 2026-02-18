/*
Time Complexity : O(n) - N nodes in the tree
Space Complexity : O(h) - height of tree in recursion stack
Approach :
We need to traverse the tree in inorder manner and keep previous node in the previous pointer. In inorder traversal, the nodes are
supposed to increasing order. If there is a breach, if we encounter a smaller value, it indicates the value was swapped. So we need
to find two breaches where the increasing order is broken. Mark these nodes as first and second, swap these nodes to recover the tree.
*/

public class RecoverBST {
    TreeNode prev;
    TreeNode first;
    TreeNode second;
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;

    }

    private void inorder(TreeNode root) {
        if(root == null) return;

        inorder(root.left);
        if(prev != null && root.val < prev.val){
            if(first != null){
                first = prev;
                second = root;
            }else {
                second = root;
            }

        }
        prev = root;
        inorder(root.right);
    }
}
