public class RecoverBST {
    //TC = O(n) SC = O(h)
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
        //base
        if(root==null)return;
        //recurse
        inorder(root.left);
        //check for breach
        if(prev!=null && prev.val>root.val){
            //first breach
            if(first==null){
                first = prev;
                second = root;
            }
            else{
                second = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
}
