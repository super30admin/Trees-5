// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class NextRightPointers {
    public Node connect(Node root) {
        if(root == null)
            return root;
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size;i++) {
                Node temp = queue.poll();
                if(i==size-1)
                    temp.next = null;
                
                if(temp.left!=null)
                {
                    temp.left.next = temp.right;
                    queue.add(temp.left);
                    queue.add(temp.right);
                }
                
                if(temp.next!=null && temp.right!=null) {
                    temp.right.next = temp.next.left;
                }
            }
        }
        
        return root;
    }
}
