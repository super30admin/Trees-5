class Solution {
    List<Integer> result;
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        dfs(root);
        return result;
    }
     private void dfs(TreeNode root){
        //base
        if(root == null){
            return;
        }

        dfs(root.left);
        result.add(root.val);
        dfs(root.right);
        //recurse
     }
}