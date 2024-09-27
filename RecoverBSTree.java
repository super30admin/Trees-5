/*
  Time: O(n)
  Space :O(h) h = height of the tree.
  Run on LeetCode: Yes
*/
class Solution {
    TreeNode first;
    TreeNode last;
    TreeNode prev;

    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = first.val;
        first.val = last.val;
        last.val = temp;
        return;
    }

    private void inorder(TreeNode node){
        if(node == null)
            return;

        inorder(node.left);
        //do inorder, get first and last.
        //in case only on missmatch, then first first and last are swaped.
        //in case two missmatch, update last.
        if(prev != null && prev.val >= node.val){
            if(first == null){
                first = prev;
            }
            last = node;
        }
        //make this node prev, in inorder manner.
        prev = node;
        inorder(node.right);
    }
}
