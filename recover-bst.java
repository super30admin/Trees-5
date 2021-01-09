// Time - O(N)
// Space - O(N)
class Solution {
    TreeNode prev;
    TreeNode first, second;
    public void recoverTree(TreeNode root) {
        if(root == null) {
            return;
        }
        
        Stack<TreeNode> st = new Stack<>();
        
        while(root != null || !st.isEmpty()) {
            while(root!=null) {
                st.push(root);
                root = root.left;
            }            
            root = st.pop();
            if(prev!=null && prev.val >= root.val) {
                if(first == null) {
                    first = prev;  
                }
                System.out.println(root.val +" " + prev.val);
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

// Time - O(N)
// Space - O(N)

class Solution {
    TreeNode prev;
    TreeNode first, second;
    public void recoverTree(TreeNode root) {
        
        
        if(root == null) {
            return;
        }
        
        inorder(root);
        
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        
    }
    
    private void inorder(TreeNode root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        if(prev != null && prev.val >= root.val) {
            if(first == null ){
                first = prev;
            }
            second = root;
        }
        prev = root;
        inorder(root.right);
    }
}
