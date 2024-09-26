/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

//Time complexity - o(n)
//Space complexity - o(1)
//Brute force -> level order usign queue extra space
class Solution {
    public Node connect(Node root) {
        Node start = root;
        while(start!=null){
            Node current= start;
            while(current!=null){
                if(current.left!=null){
                    current.left.next=current.right;
                }
                if(current.right!=null && current.next!=null){
                    current.right.next=current.next.left;
                }
                current=current.next;
            }
            start=start.left;
        }
       return root; 
        
    }
}