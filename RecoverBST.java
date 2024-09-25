// Time COmplexity: O(n)
// Space Complexity: O(n)
public class RecoverBST {
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
        Stack<TreeNode> st = new Stack<>();
        while(root!= null || !st.isEmpty()){
            while(root!= null){
                st.push(root);
                root = root.left;
            }
            root= st.pop();
            if(prev != null && prev.val >= root.val){
                if(first == null){
                    first = prev;
                    second = root;
                }
                else second = root;
            }
            prev = root;
            root = root.right;
        }
    }
}
