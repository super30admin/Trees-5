// Time Complexity -> O(n)
// Space Complexity -> O(n)
class Solution {
    List<TreeNode> tra;
    public void recoverTree(TreeNode root) {
        tra = new ArrayList<>();
        helper(root);
        TreeNode first = null;
        TreeNode second = null;
        for(int i = 1; i < tra.size(); i++){
            if(tra.get(i).val < tra.get(i-1).val){
                if(first == null){
                    first = tra.get(i-1);
                }
                second = tra.get(i);
            }
        }

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    public void helper(TreeNode root){
        if(root == null) return;
        //logic 
        helper(root.left);
        tra.add(root);
        helper(root.right);
    }
}
