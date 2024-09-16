// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//116. Populating Next Right Pointers in Each Node
//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

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
    // RECURSION
    // time: O(n)
    // space: O(h)
    public Node connect(Node root) {

        if (root == null)
            return null;

        Node head = root;
        Node left = root.left;
        Node right = root.right;

        helper(left, right);

        return head;
    }

    private void helper(Node left, Node right) {
        // base
        if (left == null)
            return;

        // logic
        left.next = right;

        helper(left.left, left.right);
        helper(left.right, right.left);
        helper(right.left, right.right);

    }
}

/*
class Solution {
    // optimized BFS
    // time: O(n)
    // space: O(1)
    public Node connect(Node root) {

        if (root == null)
            return root;

        Node head = root;
        Node level = root;
        Node curr = root;

        while (level.left != null) {

            curr.left.next = curr.right;

            if (curr.next != null) {
                curr.right.next = curr.next.left;
            }

            if (curr.next != null) {
                curr = curr.next;
            } else {
                level = level.left;
                curr = level;
            }
        }
        return head;
    }
}*/

/*
class Solution {
    // BFS
    // time: O(n) - touching all Nodes while doing BFS
    // space: O(n) - queue space
    public Node connect(Node root) {
        
        if(root == null) return root;
        
        Node head = root;
        Node curr;
        Node prev = null;
        
        Queue<Node> q = new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty()){
            
            int size = q.size();
            
            for(int i=0; i<size; i++){
                curr = q.peek();
                   
                if(curr.left!=null)
                    q.add(curr.left);
                
                if(curr.right!=null)
                    q.add(curr.right);
                
                if(i == q.size()-1)
                    curr.next = null;
                
                if(i != 0)
                    prev.next = curr;
                
                prev = curr;
                
                q.poll();
            }
        }
        return head;
    }
}*/