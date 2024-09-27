// recursive
public class RecoverBST {
    TreeNode first;
    TreeNode second;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        if(root==null) return;
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    private void inorder(TreeNode root){
        // base
        if(root==null) return;

        // logic
        inorder(root.left);
        // breach
        if(prev!=null && prev.val>=root.val){
            // first breach
            if(first==null){
                first = prev;
                second = root;
            }else{
                // second breach
                second = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
}

// TC - O(n)
// SC - O(h)


// iterative
public class RecoverBST {
    TreeNode first;
    TreeNode second;
    public void recoverTree(TreeNode root) {
        if(root==null) return;
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    private void inorder(TreeNode root){
        
        // logic
        TreeNode prev = null;
        Stack<TreeNode> st = new Stack<>();
        while(root!=null || !st.isEmpty()){
            while(root != null){
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            // breach
            if(prev!=null && prev.val>=root.val){
            // first breach
            if(first==null){
                first = prev;
                second = root;
            }else{
                second = root;
             }
            }
            prev = root;
            root = root.right;
        }
    }
}

// TC - O(n)
// SC - O(h)