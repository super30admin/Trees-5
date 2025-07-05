//Method: Using inorder recursion way

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeNode prev;
    TreeNode first, second;
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        
    }

    private void inorder(TreeNode root){
        //base
        if(root == null)x
            return;

        //logic
        inorder(root.left);
        if(prev != null && prev.val >= root.val){
            if(first == null){
                first = prev;
            }
            second = root;
        }
        prev = root;
        inorder(root.right);
    }
}


//Method: Using iterative way
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeNode prev;
    TreeNode first, second;
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        
    }

    private void inorder(TreeNode root){
       Stack<TreeNode> st = new Stack<>();

       while(!st.isEmpty() || root != null){
            //left calls 
            while(root != null){
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            if(prev != null && prev.val >= root.val){
                //first time breach
                if(first == null){
                    first = prev;
                    
                }
                second = root;
            }
            prev = root;
            //right calls
            root = root.right;
       }
    }
}