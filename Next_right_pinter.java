//Time Complexity : O(n)
// Space Complexity : O(h)
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
}

// Initially, all next pointers are set to NULL.

class next_right_pointer {
    public Node connect(Node root) {
        if(root==null)
        {
            return null;
        }
        Node left=root;
        while(left.left!=null)
        {
            Node curr= left;
            while(curr!=null)
            {
                curr.left.next=curr.right;
                if(curr.next!=null)
                {
                    curr.right.next=curr.next.left;
                }
                curr=curr.next;
            }
            left=left.left;
        }
        return root;
    }
}