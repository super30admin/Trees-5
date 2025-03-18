// Problem1 Populating Next Right Pointers in Each Node(https://leetcode.com/problems/populating-next-right-pointers-in-each-node/)

// Time Complexity : O(n) 
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, take helper fucntion on root. If root is null return. If root.next is not null assign root.left.next=root.right and if root.next
 * is not null assign root.right.next = root.next.left. In left recursion give root.left and in right recursion give root.right. Finally
 * return root.
 */
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
// 1
class Solution {
    public Node connect(Node root) {
        helper(root);
        return root;
    }
    private void helper(Node root){
        if(root == null) return;
        //logic
        if(root.left != null){
            root.left.next  = root.right;
            if(root.next != null){
            root.right.next = root.next.left;
        }
        } 
        
        helper(root.left);
        helper(root.right);
    }
}
// 2
class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        helper(root.left, root.right);
        return root;
    }
    private void helper(Node left, Node right){
        if(left == null) return;
        //logic
        left.next = right;
        helper(left.left,left.right);
        helper(left.right, right.left);
        helper(right.left, right.right);
    }
}

// 3
class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        Node level = root;
        while(level != null){
            Node curr = level;
            while(curr != null){
                if(curr.left != null){
                    curr.left.next = curr.right;
                }
                if(curr.next != null && curr.right != null){
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            level = level.left;
        }
        return root;
    }
}