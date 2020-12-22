// Time Complexity :  O(n), where n is the number of nodes in the tree
// Space Complexity : O(h), where h is the height of the tree (recursive stack space)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Correct me on the space complexity

//Three Liner approcah of your code in plain English
//1. start dfs from the root's left and right children, (making them as the current left and the right node)
//2. At every call, populate the next right pointer from curretn left node to the current right node.
//3. The current value of the left and right nodes are calculated in the following fasion
        //1. left = left.left && right = left.right
        //2. left = left.right && right = right.left
        //3. left = right.left && right = right.right
//In the end return root node, that holds the binary tree


// Your code here along with comments explaining your approach

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
        //edge case
        if(root == null) return null;
        //call dfs on left and right children of the root
        dfs(root.left, root.right);
        return root;
    }
    
    private void dfs(Node left, Node right){
        //base
        if(left == null || right == null) return;
            
        //logic
        //populate the next right pointer from the current left to the current right
        left.next = right;
        //left = left.left && right = left.right
        dfs(left.left, left.right);
        //left = left.right && right = right.left
        dfs(left.right, right.left);
        //left = right.left && right = right.right
        dfs(right.left, right.right);
    }
}