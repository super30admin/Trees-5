class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result =new ArrayList<>();
        Traversal(root,result);
        return result;
    }
    private void Traversal(TreeNode root,List<Integer> result){
        if(root==null) return;
        Traversal(root.left,result);
        result.add(root.val);
        Traversal(root.right,result);
    }
}