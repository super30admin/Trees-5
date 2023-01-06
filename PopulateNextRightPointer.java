// Time Complexity : O(n) (Most Optimised - App2 with BFS without queue)
// Space Complexity :O(1)
// n is the number of nodes in the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

import java.util.LinkedList;
import java.util.Queue;

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

//App4 - Using DFS
//TC: O(n)
//SC: O(n)
//n is the number of nodes in the tree

class PopulateNextRightPointer {
    public Node connect(Node root) {
        if(root == null)
            return root;
        helper(root);
        return root;
    }

    private void helper(Node root){

        //base
        if(root.left == null)
            return;

        //logic
        root.left.next = root.right;

        if(root.next != null){
            root.right.next = root.next.left;
        }

        helper(root.left);
        helper(root.right);
    }
}

//App3 - Using DFS
//TC: O(n)
//SC: O(n)
//n is the number of nodes in the tree

class Solution {
    public Node connect(Node root) {
        if(root == null)
            return root;
        helper(root.left,root.right);
        return root;
    }
    private void helper(Node left,Node right){
        //base case
        if(left == null)
            return;
        //logic
        left.next = right;
        helper(left.left,left.right);
        helper(left.right,right.left);
        helper(right.left,right.right);
    }
}

//App 2 - Using BFS without extra space
//TC: O(n)
//SC: O(1)
//n is the number of nodes in the tree

class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        Node level = root;

        while(level.left != null){
            Node curr = level;

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

//App 1 - Using BFS with extra space queue
//TC: O(n)
//SC: O(n)
//n is the number of nodes in the tree

class Solution {
    public Node connect(Node root) {
        if(root == null)
            return root;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node prev = null;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                Node curr = q.poll();
                if(i != 0){
                    prev.next = curr;
                }
                if(curr.left != null){
                    q.add(curr.left);
                    q.add(curr.right);
                }
                prev = curr;
            }
        }
        return root;
    }
}