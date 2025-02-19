/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

// level order traversal
// can be done by both dfs and bfs
// constraints: empty returns empty
// tc: O(N) and sc:O(1)

class Solution {

  public Node connect(Node root) {
    Node level = root;
    while (level != null) {
      Node cur = level;
      while (cur != null) {
        //point the left node to the right node
        if (cur.left != null) {
          cur.left.next = cur.right;
        }

        //handle right pointer
        if (cur.right != null && cur.next != null) {
          cur.right.next = cur.next.left;
        }

        cur = cur.next;
      }
      level = level.left;
    }
    return root;
  }
}

class Solution {

  public Node connect(Node root) {
    if (root == null) return root;
    recurse(root);
    return root;
  }

  public void recurse(Node root) {
    // base case
    if (root == null) return;

    // logic
    if (root.left != null) {
      root.left.next = root.right;
    }

    // handle right pointer
    if (root.right != null && root.next != null) {
      root.right.next = root.next.left;
    }

    // recurse
    recurse(root.left);
    recurse(root.right);
  }
}
