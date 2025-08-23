

public class RecoverBinarySearchTree {
    List<Integer> list;
    int idx;

    public void recoverTree(TreeNode root) {
        this.list = new ArrayList<>();
        this.idx = 0;
        
        helper(root);
     
        Collections.sort(list);
     
        buildTree(root);
    }

    private void helper(TreeNode root){
        if(root == null) return;

        helper(root.left);

        list.add(root.val);

        helper(root.right);
    }

    private void buildTree(TreeNode root){
        if(root == null) return;

        buildTree(root.left);

        root.val = list.get(idx++);

        buildTree(root.right);
    }
}
