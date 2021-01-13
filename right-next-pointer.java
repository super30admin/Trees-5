// DFS Recursive, Time - O(N), Space - O(H)

class Solution {
    public Node connect(Node root) {
        if(root == null) {
            return root;
        }
        
        dfs(root.left, root.right);
        
        return root;
    }
    
    private void dfs(Node left, Node right) {
        if(left == null) {
            return;
        }
        
        left.next = right;
        dfs(left.left, left.right);
        dfs(left.right, right.left);
        dfs(right.left, right.right);
    }
}
