//Time complexity: O(N) number of nodes
//Space Complexity:O(1)
public class RecoverBST {
    TreeNode prev;
    TreeNode node1;
    TreeNode node2;
    public void recoverTree(TreeNode root) {
        traverse(root);
        //swap node1 and node2;
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }

    private void traverse(TreeNode root){
        if(root == null) return;


        traverse(root.left);
        //prev < root(should for a BST)
        if(prev != null && prev.val > root.val){

            if(node1 == null){
                node1 = prev;
                node2 = root;
            }
            else{
                node2 = root;
            }
        }
        prev = root;
        traverse(root.right);
    }
}
