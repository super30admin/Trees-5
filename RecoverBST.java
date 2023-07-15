import java.util.Stack;

// Time Complexity : O(n) where n is the number of nodes as we need to visit each node at least once
// Space Complexity : O(log n) where n is the number of nodes in the tree
// Did this code successfully run on Leetcode :yes
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class RecoverBST {
    private TreeNode prev;
    private TreeNode first;
    private TreeNode second;
    private Stack<TreeNode> st;
    public void recoverTree(TreeNode root) {
        inorder(root);
        //swap
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode node){
        //base
        if(node == null) return;

        //logic
        inorder(node.left);

        if(prev != null && node.val < prev.val){
            if(first == null){
                first = prev;
                second = node;
            }else{
                second = node;
            }

        }
        prev = node;
        inorder(node.right);
    }

    private void inorderiterative(TreeNode node){
        while(!st.isEmpty() || node != null){
            while(node!= null){
                st.push(node);
                node = node.left;
            }
            //process
            node = st.pop();
            if(prev != null && node.val < prev.val){
                if(first == null){
                    first = prev;
                    second = node;
                }else{
                    second = node;
                }
            }
            prev = node;
            node = node.right;
        }
    }
}
