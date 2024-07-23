
/*
 * //Tc: O(n) Sc: O(1)
 * class Solution {
 * public Node connect(Node root) {
 * 
 * if(root == null) return root;
 * Node cur = root;
 * while(cur.left != null)
 * {
 * Node head = cur;
 * while(head != null)
 * {
 * head.left.next = head.right;
 * if(head.next != null)
 * {
 * head.right.next = head.next.left;
 * }
 * head = head.next;
 * }
 * cur = cur.left;
 * }
 * return root;
 * }
 * }
 */

/*
 * class Solution {
 * //Tc: O(n) Sc: O(n)
 * public Node connect(Node root) {
 * if (root == null)
 * return root;
 * 
 * Queue<Node> q = new LinkedList<Node>();
 * q.add(root);
 * 
 * while (!q.isEmpty()) {
 * int size = q.size();
 * for (int i = 0; i < size; i++) {
 * Node cur = q.poll();
 * 
 * if (i < size - 1)
 * cur.next = q.peek();
 * 
 * if (cur.left != null)
 * q.add(cur.left);
 * if (cur.right != null)
 * q.add(cur.right);
 * }
 * }
 * return root;
 * }
 * }
 */