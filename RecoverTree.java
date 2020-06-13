
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/**
 * Time complexity: O(N) where N is number of nodes in tree.
 * Space complexity: O(N) is size of recursion stack.
 * 
 * Approach:
 * 1. Breaches can be identified by inorder traversal, where the ascending order is changed, is the point
 * of breach.
 * 2. The points or nodes at which breaches are occurred are identified and are replaced.
 */
class RecoverTree {
    
    TreeNode firstNode, lastNode; // Nodes to be swapped
    TreeNode prevNode; // for inorder traversal
    
    public void recoverTree(TreeNode root) {
        
        helper(root);
        
        /*
        swap nodes' values
        */
        int x = firstNode.val;
        firstNode.val = lastNode.val;
        lastNode.val = x;
        
    }
    
    private void helper(TreeNode node) {
        
        if(node == null)
            return;
        
        helper(node.left);
        
        if(prevNode != null) {
            
            if(prevNode.val > node.val) {
                
                if(firstNode == null) {
                    firstNode = prevNode;
                }
                lastNode = node;
            }
            
        }
        
        prevNode = node;
        helper(node.right);
    }
}