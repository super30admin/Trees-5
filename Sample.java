// Problem 1 - Populating Next Right Pointers in Each Node II
// Time Complexity:
// Space Complexity:

// Algorithm
// 1 - initiliaze queue
// 2 - add root to queue
// 3 - while condition
// 4 - get size of queue
// 5 - initialize a node
// 6 - loop over the size of queue
// 7 - get front node from the queue
// 8 - add current node to prev node
// 9 - if left node to root present, add it to queue
// 10 - if right node to root present, add it to queue
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

class Solution {
  public Node connect(Node root) {
    if (root == null) {
      return root;
    }
    // 1
    Queue<Node> queue = new LinkedList<>();
    // 2
    queue.add(root);
    // 3
    while (!queue.isEmpty()) {
      // 4
      int size = queue.size();
      // 5
      Node prev = null;
      // 6
      for (int i=0; i<size; i++) {
        // 7
        Node curr = queue.poll();
        // 8
        if (prev != null) {
          prev.next = curr;
        }
        prev = curr;
        // 9
        if (curr.left != null) {
          queue.add(curr.left);
        }
        // 10
        if (curr.right != null) {
          queue.add(curr.right);
        }
      }
    }

    return root;
  }
}
