// Time Complexity : O(N)
// Space Complexity : O(N) - number of recursive calls stored on system stack or user defined stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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

// Iteration
// class Solution {
//     public void recoverTree(TreeNode root) {
//         if (root == null)
//             return;
        
//         TreeNode first=null, second=null, cursor=root;
//         TreeNode prev = new TreeNode(Integer.MIN_VALUE);
//         Stack<TreeNode> stack = new Stack<>();
        
//         while(cursor != null)
//         {
//             stack.push(cursor);
//             cursor=cursor.left;
//         }
        
//         while(!stack.isEmpty())
//         {
//             cursor=stack.pop();
//             if(first == null && prev.val > cursor.val)
//                 first=prev;
//             if(first != null && prev.val > cursor.val)
//                 second=cursor;
            
//             prev=cursor;
            
//             if(cursor.right != null) {
//                 cursor=cursor.right;
//                 while(cursor != null) {
//                     stack.push(cursor);
//                     cursor=cursor.left;
//                 }
//             }
//         }
//         swap(first, second);
//     }
//     private void swap(TreeNode a, TreeNode b){
//         int val=a.val;
//         a.val=b.val;
//         b.val=val;
//     }
// }


/*----------------------------------*/
//Recursion
class Solution {
    TreeNode first, second, prev, cursor;
    
    public void recoverTree(TreeNode root) {
        if (root == null)
            return;
        
        first=null; second=null;
        prev = new TreeNode(Integer.MIN_VALUE);
        
        inOrder(root);
        
        swap(first, second);
    }
    private void inOrder(TreeNode root){
        if(root == null)
            return ;
        
        inOrder(root.left);
        
        if(first == null && prev.val > root.val)
            first=prev;
        if(first != null && prev.val > root.val)
            second=root;
        prev=root;
        
        inOrder(root.right);
    }
    private void swap(TreeNode a, TreeNode b){
        int val=a.val;
        a.val=b.val;
        b.val=val;
    }
}
