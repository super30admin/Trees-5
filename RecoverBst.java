
public class RecoverBst {
    TreeNode first, second;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        //iteratively
        Stack<TreeNode> st = new Stack<>();
        while(!st.isEmpty() || root != null){
            while(root != null){
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            if(prev != null && prev.val >= root.val){
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

        // helper(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    public void helper(TreeNode root){
        //inorder 
        //base
        if(root == null) return;

        //logic
        helper(root.left);
        if(prev != null && prev.val >= root.val){
            if(first == null){
                first = prev;
                second = root;
            }else{
                second = root;
            }
        }
        prev = root;
        helper(root.right);
    }

}
