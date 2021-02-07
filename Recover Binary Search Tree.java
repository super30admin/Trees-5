/*
class Solution:
    def recoverTree(self, root: TreeNode) -> None:
        if root is None:
            return 
        
        self.first = None
        self.second = None
        self.prev = None
        
        self.inorder(root)
        
        temp = self.first.val
        self.first.val = self.second.val
        self.second.val = temp
        
    def inorder(self, root):
        if root is None:
            return
        
        self.inorder(root.left)
        if self.prev is not None and self.prev.val > root.val:
            if self.first is None:
                self.first = self.prev
            self.second = root
        self.prev = root
        self.inorder(root.right)
*/

/*
class Solution {
    TreeNode first, second, prev;
    public void recoverTree(TreeNode root) {
        if (root == null)
            return;
        
        Stack<TreeNode> st = new Stack<>();
        
        while (root != null || !st.isEmpty()){
             while (root != null){
                 st.push(root);
                 root = root.left;
             }
            
            root = st.pop();
             if (prev != null && prev.val > root.val){
                 if (first == null){
                     first = prev;
                 } 
                 second = root;
             }
            prev = root;
            root = root.right;
        }
        
        
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
}
*/

// Time - O(h) where h is height of tree
// Space - O(h)
// Logic - if we take inorder traversal then every prev should be less than its next element There will be at most two places where this
// condition will be breached
class Solution {
    TreeNode first, second, prev;
    public void recoverTree(TreeNode root) {
        if (root == null)
            return;
        
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    private void inorder(TreeNode root){
        if (root == null)
            return;
        
        inorder(root.left);
        if (prev != null && prev.val > root.val){
            if (first == null)
                first = prev;
            second = root;
        }
        prev = root;
        
        inorder(root.right);
    }
}