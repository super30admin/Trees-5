// recursion, iterative
// tc: O(n) sc: O(1)

class Solution {

  ArrayList<Integer> result = new ArrayList<>();

  public List<Integer> inorderTraversal(TreeNode root) {
    if (root == null) return result;
    recurse(root);
    return result;
  }

  public void recurse(TreeNode root) {
    // base case
    if (root == null) return;

    recurse(root.left);
    result.add(root.val);
    recurse(root.right);
  }
}

//MOrris inorder traversal
class Solution {

  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();

    TreeNode curr = root;

    while (curr != null) {
      if (curr.left == null) {
        result.add(curr.val);

        curr = curr.right;
      } else {
        TreeNode pre = curr.left;

        while (pre.right != null && pre.right != curr) {
          pre = pre.right;
        }

        if (pre.right == null) {
          pre.right = curr;

          curr = curr.left;
        } else {
          result.add(curr.val);

          curr = curr.right;

          pre.right = null;
        }
      }
    }

    return result;
  }
}
