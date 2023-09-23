//TC = O(n)
//SC = O(n)

//Here we are inorder travelsal so that element will be arranged 
// in order then we will swap thw elements.

class Solution {
    TreeNode first;
    TreeNode Second;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        if (root == null) return;
        inorder(root);
        int temp first.val;
        first.val = second.val;
        second.val = temp;
    }
    private void inorder(TreeNode root){
        //base
        if(root = null) return;

        //logic
        inorder(root.left);
        if(prev.val>=root.val && prev != null){
            if(first == null){
                first = prev;
                second = root;
            }else{
                second = root;
            }
        }
        prev = root;
        inroder(root.right);

    }
}