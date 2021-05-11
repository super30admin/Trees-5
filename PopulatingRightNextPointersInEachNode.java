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

// Approach - Breadth First Search
//Time Complexity - O(N) - where N is number of nodes in the tree
//Space Complexity - O(N) - for the queue

class Solution {
  public Node connect(Node root) {

    if(root == null){
      return root;
    }

    Queue<Node> queue = new LinkedList<>();
    queue.add(root);

    while(!queue.isEmpty()){
      int size = queue.size();

      for(int i=0; i<size; i++){
        Node node = queue.poll();

        if (i < size - 1) {
          node.next = queue.peek();
        }

        if(node.left != null){
          queue.add(node.left);
        }

        if(node.right != null){
          queue.add(node.right);
        }
      }
    }
    return root;
  }
}




// Approach - Using Previously established next pointers
//Time Complexity - O(N) - where N is number of nodes in the tree
//Space Complexity - O(1)
class Solution {
  public Node connect(Node root) {

    if(root == null){
      return root;
    }

    Node leftmost = root;

    while(leftmost.left != null){

      Node curr = leftmost;

      while(curr != null){
        curr.left.next = curr.right;

        if(curr.next != null){
          curr.right.next = curr.next.left;
        }

        curr = curr.next;
      }

      leftmost = leftmost.left;
    }
    return root;
  }
}
