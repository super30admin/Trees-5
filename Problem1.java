// Time: O(n)
// Space: O(1)

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
        if(root ==null) return root;


        Node tempLeft = root;

        while(tempLeft.left != null){
            Node temp = tempLeft;
            while(temp!=null){
                temp.left.next = temp.right;
                if(temp.next!= null){
                    temp.right.next = temp.next.left;
                }
                temp = temp.next;
            }
            tempLeft = tempLeft.left;
        
        }

        return root;
        
    }
}











