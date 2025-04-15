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

// dfs
// Time Complexity : O(n)
// Space Complexity :O(log(n)) // under the hood
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// see the left and right of the root and assign the left and right by calling recursively
// Your code here along with comments explaining your approach

class Solution {
    public Node connect(Node root) {
        if( root == null ) return null;
        helper(root.left, root.right);
        return root;
    }
    private void helper(Node left, Node right){
        // base
        if( left == null ) return;
        // logic
        left.next = right;
        helper(left.left, left.right);
        helper(right.left, right.right);
        helper(left.right, right.left);
    }

}

// bfs
// Time Complexity : O(n)
// // Space Complexity :O(1)
// // Did this code successfully run on Leetcode : Yes
// // Three line explanation of solution in plain english
// // use use the level and curr pointer to point the level and curr starts form the left of the tree;
// // Your code here along with comments explaining your approach

// // bfs - without using stack
// class Solution {
//     public Node connect(Node root) {
//         if( root == null ) return null;
//         Node level = root;
//         Node curr = null;
//         while( level.left != null){
//             curr = level;
//             while(curr != null){
//                 curr.left.next = curr.right;
//                 if( curr.next != null){
//                     curr.right.next = curr.next.left;
//                 }
//                 curr = curr.next;
//             }
//             level = level.left;
//         }
//         return root;
//     }
// }

// // dfs - level order as per sir
// class Solution {
//     public Node connect(Node root) {
//         if(root == null ) return null;
//         helper(root, 1, new ArrayList<>());
//         return root;
//     }
//     private void helper(Node root, int level, ArrayList<Node> q)  {
//         //base
//         if( root == null ) return;
//         //logic
//         root.next = null;
//         if(q.size() == level){
//             q.get(level-1).next = root;
//             q.remove(level-1);
//         }
//         q.add(root);
//         // left
//         helper(root.left,level+1,q);
//         // right
//         helper(root.right,level+1,q);
//     }
// }

// // bfs
// class Solution {
//     public Node connect(Node root) {
//         if(root == null) return null;
//         Queue<Node> q = new LinkedList<>();
//         q.add(root);
//         while(!q.isEmpty()){
//             int size = q.size();
//             for(int i=0; i<size; i++){
//                 Node myRoot = q.poll();
//                 if( i+1 == size){
//                     myRoot.next = null;
//                 }else{
//                     myRoot.next = q.peek();
//                 }
//                 if(myRoot.left != null) q.add(myRoot.left);
//                 if(myRoot.right != null) q.add(myRoot.right);
//             }
//         }
//         return root;
//     }
// }