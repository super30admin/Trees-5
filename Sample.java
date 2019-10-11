// Time Complexity : O(n)
// Space Complexity : O(n)
// Your code here along with comments explaining your approach
// Approach: Recursively make a node point to next node. 
// Make left child of left child point to its sibling
// Make right child of left child point to its immidiate cousin.
// Make left child of right child point to its sibling

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
class Solution {
    public Node connect(Node root) {
        if(root==null) return root;
        func(root.left,root.right);
        return root;
    }
    public void func(Node node1, Node node2){
        if(node1==null) return;
        node1.next = node2;
        func(node1.left,node1.right);
        func(node1.right,node2.left);
        func(node2.left,node2.right);
    }
}

// Time Complexity : O(n)
// Space Complexity : O(n)
// Your code here along with comments explaining your approach
// Approach: Traverse BST in inorder fashion. For every node visited, keep track of prev node visited.
// if prev node's val is greater than node's value, then these 2 nodes would have to bve swapped.
// if we find more such pairs of nodes, then we've to swap first found prev node and last found curr node.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode n1,n2,prev;
    public void recoverTree(TreeNode root) {
        func(root);
        swap(n1,n2);
    }
    private void func(TreeNode node){
        if(node==null) return;
        func(node.left);
        if(prev!=null){
            if(prev.val>node.val){
                if(n1==null){
                    n1 = prev;
                    n2 = node;
                }
                n2 = node;
            }
        }
        prev = node;
        func(node.right);
    }
    private void swap(TreeNode n1, TreeNode n2){
        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;
    }
}
