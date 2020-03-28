// Problem2 Recover Binary Search Tree(https://leetcode.com/problems/recover-binary-search-tree/)

//Recursive
// Time - O(n)
// Space - O(Height of the tree)
class Solution { 
    
    TreeNode first;
    TreeNode second;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        swap(first, second);
    }
    
    private void inorder(TreeNode root){
        if(root == null) return;
        
        inorder(root.left);
        if(first == null && prev.val > root.val){
            first = prev;
        }
        
         if(first != null && prev.val > root.val){
            second = root;
        }
        prev = root;
        inorder(root.right);
    }
    
    
    private void swap(TreeNode node1, TreeNode node2){
        int val = node1.val;
        node1.val = node2.val;
        node2.val = val;
        
    }
}

//Iterative
// Time - O(n)
// Space - O(n)
class Solution { 
    
    
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        TreeNode first = null;
        TreeNode second  = null;
        TreeNode prev = new TreeNode(Integer.MIN_VALUE);
        
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();
        // Iterate towards the left
        while(curr != null){
            stack.push(curr);       
            curr = curr.left;
        }
        
        while(!stack.isEmpty()){
            curr = stack.pop();
            if(first == null && prev.val > curr.val){
                first = prev;
            }
            
            if(first != null && prev.val > curr.val){
                second = curr;
            }
            prev = curr;
            if(curr.right != null){
                curr = curr.right;
                while(curr != null){
                    stack.push(curr);
                    curr = curr.left;
               
                }
            } 
        }
        swap(first, second);
    }
    
    private void swap(TreeNode node1, TreeNode node2){
        int val = node1.val;
        node1.val = node2.val;
        node2.val = val;
        
    }
}