import java.util.Stack;

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

// Using : Recursion (inorder)
// TC : O(n)
// SC : O(h)
class RecoverBST {
    TreeNode first;
    TreeNode second;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode root){
        //base
        if(root == null) return;
        //logic
        inorder(root.left);
        if(prev!= null && prev.val >= root.val){
            //breach
            if(first == null){
                first = prev;
                second = root;
            }else{
                second = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
}

// USTING : IERATIVE
// TC : O(n)
// SC : O(h)
class RecoverBSTIterative {
    TreeNode first;
    TreeNode second;
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode root){
        //base
        if(root == null) return;
        TreeNode prev = null;
        Stack<TreeNode> st = new Stack<>();
        while(root != null || st.isEmpty()){
            while(root != null){
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            if(prev!= null && prev.val >= root.val){
            //breach
            if(first == null){
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