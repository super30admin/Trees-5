//Optimized BFS:- O(1) space
//Time complexity:- O(n)
//Space complexity:- O(1)

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
        
        if(root == null)
            return root;

        //Optimized BFS without the extra space for queue
        Node level = root;

        //we will traverse level by level starting from root to leaf
        while(level.left != null) {

            //we will go from left to right on each level
            Node curr = level;

            //skip the rightmost node as the next is always null
            while(curr != null) {
                
                curr.left.next = curr.right;

                if(curr.next != null)
                    curr.right.next = curr.next.left;
                
                curr = curr.next;
            }

            level = level.left;
        }

        return root;
    }
}
