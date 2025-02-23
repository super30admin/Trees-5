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

class Solution {
	//Time Complexity:O(n)
	//Space Complexity:O(n)
    public Node connect(Node root) {
         if(root == null) return null;
        if(root.left==null && root.right==null) {
            // root.next=null;
            return root;
        }
       if (root.left != null && root.right != null) {
        root.left.next= root.right;
       } else {
        root.left.next= null;
       }

       if (root.next !=null && root.next.left != null) {
        root.right.next = root.next.left;
       } else {
        root.right.next = null;
       }
        connect (root.left);
        connect (root.right);

       return root;
    }
}
