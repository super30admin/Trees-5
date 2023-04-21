// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/*
Combine elements of roots children and merge them by using the next pointer.
If children belong to same root, do a root.left.next = root.right to point to the next right node on the level. 
If children belong to different roots, merge them together 
 * */
 


public class Problem1 {
    public Node connect(Node root) {
        if(root == null)
            return root; 
        dfs(root);
        return root;
    }
    private void dfs(Node root){
        if(root.left == null)
            return; 
        root.left.next = root.right; 
        if(root.next != null){
            root.right.next = root.next.left;
        }
        dfs(root.left);
        dfs(root.right);
    }
}
