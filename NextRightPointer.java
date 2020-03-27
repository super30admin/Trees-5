i/*
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
        if(root == null)
            return null;
        return connectUsingLevelOrder(root);
        //return connectUtil(root);
    }
    /*
    Brute force way would be to do level order traversal and while doing level order traversal keep connecting the  
    nodes at the same level. But that would take extra space for storing the nodes in the queue. 
    Time Complexity: O(N) where N is number of nodes in the tree.
    Space Complexity: O(N/2) maximum width of the tree. 
    */
    private Node connectUsingLevelOrder(Node root){
         if(root == null)
             return null;
          Queue<Node> q = new LinkedList<>();
          q.add(root);
          while(!q.isEmpty()){
              int size = q.size() ;
              for(int i=0; i< size; i++){
                 Node node = q.remove();
                  if(i < size-1)
                    node.next = q.peek();
                  if (node.left != null) 
                    q.add(node.left);
                  if (node.right != null) {
                    q.add(node.right);
                }
              }
          }
          return root;
    }
    /*
    I would be connecting nodes at each level with the help of dummy node. Connecing root's left with root's right
    Time Complexity: O(N) where N is number of nodes in the tree.
    Space Complexity: O(1) not using extra space
    */
    private Node connectUtil(Node root){
        Node dummy = new Node(-1);
        Node ptr = dummy;
        Node cur = root;
        while(root != null){
            if(root.left != null){
                ptr.next = root.left;
                ptr = ptr.next;
            }
            if(root.right != null){
                ptr.next = root.right;
                ptr = ptr.next;
            }
            root = root.next;
            if(root == null){
                ptr = dummy;
                root = dummy.next;
                dummy.next = null;
            }
        }
        return cur;
    }
}
