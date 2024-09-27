package Dec7;

/*
//Definition for a Node.
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

class PopulateNextRightPointers {
 
 /*
 Time Complexity: O(n)  because we are traversing through all tree node exactly once.
 Space Complexity: O(1) because no auxiliary data storage used.
 
 Approach: 
 2 pointers used. No auxiliary data storage used.
 'level' pointer used to maintain level.
 'cur' pointer used to iterate through all nodes of current level.

 */
 public Node connect(Node root) {
     // edge
     if (root == null) {
         return null;
     }
     
     Node level = root;
     while (level.left != null) {
         Node cur = level;
         while (cur != null) {
             cur.left.next = cur.right;
             if (cur.next != null) {
                 cur.right.next = cur.next.left;
             }
             cur = cur.next;
         }
         level = level.left;   
     }
    
     return root;
 }
}