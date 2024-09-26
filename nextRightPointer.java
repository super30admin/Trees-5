// Time Complexity : O(N)
// Space Complexity : Recursive O(H) or Iterative O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
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

class Solution {
    private void helper(Node left,Node right){
        if(left == null) return;
        left.next = right;
        helper(left.left,left.right);
        
        helper(left.right,right.left);
        helper(right.left,right.right);
        
        
    }
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
        
        
        
        
//         if(root == null) return root;
//         helper(root.left,root.right);
//         return root;
        
        
        
//         if(root == null) return root;
//         Queue<Node> q = new LinkedList<>();
//         q.add(root);
//         while(!q.isEmpty()){
//             int size = q.size();
//             Node prev = null;
//             for(int i = 0 ; i < size ; i++){
//                 Node curr = q.poll();
//                 if(i != 0)
//                     prev.next = curr;
//                 prev = curr;    
//                 if(curr.left != null) q.add(curr.left);
//                 if(curr.right != null) q.add(curr.right);
                
                
//             }
//         }
//         return root;
    }
}
