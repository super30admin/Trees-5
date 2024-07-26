T.c --> O(n)
S.c --> O(n)
class Solution {
    List<Integer> result = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {        
        inorder(root);
        return result;
    }

    private void inorder(TreeNode root){
        if(root == null){
           return;
        }
        inorder(root.left);
        if(root != null){
          result.add(root.val);
        }
        inorder(root.right);
    }
}