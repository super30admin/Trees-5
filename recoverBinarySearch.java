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

/*
 * class Solution {
 * //Tc: O(n) Sc: O(1)
 * TreeNode first;
 * TreeNode middle;
 * TreeNode last;
 * TreeNode prev;
 * 
 * private void inorder(TreeNode root)
 * {
 * if(root == null) return;
 * inorder(root.left);
 * 
 * if(prev != null && (root.val < prev.val))
 * {
 * if(first == null)
 * {
 * first = prev;
 * middle = root;
 * }
 * else
 * {
 * last = root;
 * }
 * }
 * 
 * prev = root;
 * inorder(root.right);
 * }
 * 
 * public void recoverTree(TreeNode root) {
 * first = middle = last = null;
 * 
 * inorder(root);
 * 
 * if(first != null && last != null)
 * {
 * int temp = first.val;
 * first.val = last.val;
 * last.val = temp;
 * }
 * 
 * else if(first != null && middle != null)
 * {
 * int temp = first.val;
 * first.val = middle.val;
 * middle.val = temp;
 * }
 * }
 * }
 */

/*
 * class Solution {
 * List<Integer> ans = new ArrayList<>();
 * 
 * public void recoverTree(TreeNode root) {
 * 
 * inorder(root);
 * Collections.sort(ans);
 * 
 * Iterator<Integer> it = ans.iterator();
 * replace(root, it);
 * 
 * }
 * 
 * private void inorder(TreeNode root) {
 * 
 * if (root == null)
 * return;
 * inorder(root.left);
 * ans.add(root.val);
 * inorder(root.right);
 * }
 * 
 * private void replace(TreeNode root, Iterator<Integer> it) {
 * if (root == null)
 * return;
 * replace(root.left, it);
 * if (it.hasNext()) {
 * root.val = it.next();
 * }
 * replace(root.right, it);
 * }
 * }
 * 
 */