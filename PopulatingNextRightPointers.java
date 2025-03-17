//In this approach, we use two pointers, level and curr to traverse the level of the tree and traverse through each level using curr pointer and at each node, we put it's next pointer to next node
//Time Complexity: O(n)
//Space Complexity: O(h) where h is the height of the tree.
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
    public Node connect(Node root) {
        if(root == null) return root;
        Node level = root;
        Node curr = root;
        while(level.left != null){
            curr = level;
            while(curr != null){
                curr.left.next = curr.right;
                if(curr.next != null){
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            level = level.left;
        }
        return root;
    }
}



//Here, we use DFS approach where we take 2 nodes, left and right. 
//At each node in a level, we point the left's left to left's right, left's right to right's left and right's left to right's right
//Time Complexity: O(n)
//Space Complexity: O(h) recursive stack space
class Solution1 {
    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        helper(root.left, root.right);
        return root;
    }

    private void helper(Node left, Node right){
        //base
        if(left == null){
            return;
        }
        //logic
        left.next = right;
        helper(left.left, left.right);
        helper(left.right, right.left);
        helper(right.left, right.right);
    }
}