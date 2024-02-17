// 116. Populating Next Right Pointers in Each Node


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
        
        Node levelFirst = root;
        Node temp = root;

        while(levelFirst != null){
            temp = levelFirst;
            while(temp != null){
                if(temp.left != null) temp.left.next = temp.right;
                if(temp.right != null) temp.right.next = temp.next != null ? temp.next.left : null;
                temp = temp.next;
            }
            levelFirst = levelFirst.left;
        }

        return root;
    }
}
