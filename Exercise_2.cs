
 // Time complexity : O(n) we need to travel all the nodes 
 // Space complexity: O(1) no need to use extra space 
public class Solution {
    TreeNode prev;
    TreeNode curr;
    TreeNode first;
    TreeNode second;
    public void RecoverTree(TreeNode root) {
        if(root == null) return;
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        
    }


    public void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        prev = curr;
        curr = root;
        if(prev!=null && curr!=null && prev.val > curr.val){
            if(first==null) {first = prev; second = curr;}
            else{ second = curr;}
        }

        inorder(root.right);
    }
}