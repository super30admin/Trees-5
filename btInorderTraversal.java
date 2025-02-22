import java.util.ArrayList;
import java.util.List;


class btInorderTraversal {
    List<Integer> result = new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return new ArrayList<> ();
        }
        inorder(root);
        return result;
    }
    private void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        result.add(root.val);
        inorder(root.right);
    }
}