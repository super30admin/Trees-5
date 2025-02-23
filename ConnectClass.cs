//TC => O(n)
//SC => O(1)
/*
// Definition for a Node.
public class Node {
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
*/

public class Solution
{
    public Node Connect(Node root)
    {
        if (root == null)
        {
            return root;
        }

        var left = root;
        while (left.left != null)
        {
            var current = left;
            while (current != null)
            {
                current.left.next = current.right;
                if (current.next != null)
                {
                    current.right.next = current.next.left;
                }
                current = current.next;
            }
            left = left.left;
        }

        return root;
    }
}