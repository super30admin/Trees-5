// Time Complexity : O(n)
// Space Complexity : O(1) for iterative / O(h) for recursive
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

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

// class Solution {
//     public Node connect(Node root) {
//         dfs(root);
//         return root;
//     }
//     private void dfs(Node root){
//         if(root == null){
//             return;
//         }

//         root.left.next = root.right;
//         if(root.next != null){
//             root.right.next = root.next.left;
//         }
//         dfs(root.left);
//         dfs(root.right);
//     }
    
// }

//iterative
// class Solution {
//     public Node connect(Node root) {
//         if(root == null){
//             return root;
//         }
//         Node left = root;
//         while(left.left != null){
//             Node curr = left;
//             while(curr != null){//traverse the row
//                 curr.left.next = curr.right;
//                 if(curr.next != null){
//                     curr.right.next = curr.next.left;
//                 }
//                 curr = curr.next;
//             }
//             left = left.left;// next row
//         }
//         return root;
//     }
// }

//recursive
class Solution {
    public Node connect(Node root) {
        if(root == null){
            return root;
        }

        dfs(root.left, root.right);
        return root;
    }

    private void dfs(Node left, Node right ){
        if(left == null){
            return;
        }
        left.next = right;
        dfs(left.left, left.right);
        dfs(left.right, right.left);
        dfs(right.left, right.right); 
    }
}
