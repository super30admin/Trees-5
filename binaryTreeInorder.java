
/*
 * class Solution {
 * // Tc: O(n) Sc: O(1)
 * 
 * public List<Integer> inorderTraversal(TreeNode root) {
 * List<Integer> ans = new ArrayList<>();
 * TreeNode cur = root;
 * TreeNode prev;
 * 
 * while (cur != null) {
 * if (cur.left == null) {
 * ans.add(cur.val);
 * cur = cur.right;
 * }
 * 
 * else {
 * prev = cur.left;
 * while (prev.right != null) {
 * prev = prev.right;
 * }
 * prev.right = cur;
 * 
 * TreeNode temp = cur;
 * cur = cur.left;
 * temp.left = null;
 * 
 * }
 * }
 * 
 * return ans;
 * }
 * }
 * 
 * /**
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
 * // Tc: O(n) Sc: O(n)
 * public List<Integer> inorderTraversal(TreeNode root) {
 * 
 * List<Integer> ans = new ArrayList<>();
 * Stack<TreeNode> st = new Stack<>();
 * 
 * TreeNode cur = root;
 * 
 * while (!st.isEmpty() || cur != null) {
 * 
 * while (cur != null) {
 * st.push(cur);
 * cur = cur.left;
 * }
 * 
 * cur = st.pop();
 * ans.add(cur.val);
 * cur = cur.right;
 * }
 * return ans;
 * }
 * 
 * }
 * 
 */

/*
 * 
 * class Solution {
 * List<Integer> ans = new ArrayList<>();
 * 
 * public List<Integer> inorderTraversal(TreeNode root) {
 * //Tc: O(n) Sc: O(n)
 * inorder(root);
 * return ans;
 * }
 * 
 * private void inorder(TreeNode root) {
 * if (root == null)
 * return;
 * inorder(root.left);
 * ans.add(root.val);
 * inorder(root.right);
 * }
 * }
 * 
 */