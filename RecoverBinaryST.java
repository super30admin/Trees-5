// bst - rule - left < root < right
// inorder traversal -> tracking two nodes?
// it's mostly going to be between root and node? - nope
// swap nodes is the objective -
// recursive - will give O(n) - SC
// morris inorder. will give O(1) - SC
// tc: O(n) for both ways

class Solution {

  TreeNode first;
  TreeNode last;

  TreeNode prev;
  boolean flag;

  public void recoverTree(TreeNode root) {
    if (root == null) return;

    inorder(root);

    int temp = last.val;

    last.val = first.val;

    first.val = temp;
  }

  private void inorder(TreeNode root) {
    if (root == null) return;

    inorder(root.left);

    //root = st.pop();

    if (prev != null && root.val < prev.val) {
      if (!flag) {
        flag = true;

        first = prev;
        last = root;
      } else {
        last = root;
      }
    }

    prev = root;

    inorder(root.right);
  }
}

// morris inorder
class Solution {

  public void swap(TreeNode a, TreeNode b) {
    int tmp = a.val;
    a.val = b.val;
    b.val = tmp;
  }

  public void recoverTree(TreeNode root) {
    // predecessor is a Morris predecessor.
    // In the 'loop' cases it could be equal to the node itself predecessor == root.
    // pred is a 'true' predecessor,
    // the previous node in the inorder traversal.
    TreeNode x = null, y = null, pred = null, predecessor = null;

    while (root != null) {
      // If there is a left child
      // then compute the predecessor.
      // If there is no link predecessor.right = root --> set it.
      // If there is a link predecessor.right = root --> break it.
      if (root.left != null) {
        // Predecessor node is one step left
        // and then right till you can.
        predecessor = root.left;
        while (
          predecessor.right != null && predecessor.right != root
        ) predecessor = predecessor.right;

        // Set the link predecessor.right = root
        // and go to explore left subtree
        if (predecessor.right == null) {
          predecessor.right = root;
          root = root.left;
        }
        // Break the link predecessor.right = root
        // link is broken : time to change subtree and go right
        else {
          // Check for the swapped nodes
          if (pred != null && root.val < pred.val) {
            y = root;
            if (x == null) x = pred;
          }
          pred = root;

          predecessor.right = null;
          root = root.right;
        }
      }
      // If there is no left child
      // then just go right.
      else {
        // Check for the swapped nodes
        if (pred != null && root.val < pred.val) {
          y = root;
          if (x == null) x = pred;
        }
        pred = root;

        root = root.right;
      }
    }
    swap(x, y);
  }
}
