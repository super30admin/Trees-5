
# Time complexity:O(n)
# Space complexity: 0(n)
# Did code run successfully on leetcode: yes
# Any problem you faced: No



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
    public Node connect(Node node) {
        if(node == null) return node;

        if(node.left != null){
            node.left.next = node.right;
            if(node.next != null){
                node.right.next = node.next.left;

            }
        }

        connect(node.left);
        connect(node.right);

        return node;

    }
}