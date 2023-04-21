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
        // // OPTIMIZED BFS
        // // TC-O(N),SC-O(1)
        // go till level - 1 and in each level, loop through all the nodes by using next pointer as next are set for that level in previous iteration, by setting curr=level initially and iterate till curr is not null
        // set curr.left.next=curr.right and curr.right.next = curr.next.left repeat till curr is null
        // go to next level and repeat
        // if(root==null) return root;
        // Node level = root;
        // while(level.left!=null){
        //     Node curr = level;
        //     while(curr!=null){
        //         curr.left.next = curr.right;
        //         if(curr.next!=null){
        //             curr.right.next = curr.next.left;
        //         }
        //         curr=curr.next;
        //     }
        //     level = level.left;
        // }
        // return root;
        //dfs
        // go through each level, using left and right children
        // attach left.left and left.right, left.right and right.left , right.left and right.right
        // TC-O(N),SC-O(1)
        if(root==null) return root;
        dfs(root.left,root.right);
        return root;
    }

    public void dfs(Node left, Node right){
        if(left==null) return ;
        left.next = right;
        dfs(left.left,left.right);
        dfs(left.right,right.left);
        dfs(right.left,right.right);
    }
}