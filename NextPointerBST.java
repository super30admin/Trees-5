// Time Complexity : O(n) n to traverse all nodes to connect each node to it's next node(right node)
// Space Complexity : O(1) No recursion since we're traversing level by level
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class NextPointerBST {
    public Node connect(Node root) {
        if(root==null) return root;
        Node level = root;
        while(level.left != null){
            Node curr = level;
            while(curr!=null){
                curr.left.next=curr.right;
                if(curr.next!=null){
                    curr.right.next = curr.next.left;
                }
                curr=curr.next;
            }
            level = level.left;
        }
        return root;
    }
}

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