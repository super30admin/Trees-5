//Time Complexity - O(n)

import java.util.*;

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

class Solution {
    TreeNode first;
    TreeNode last;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        if(root == null){
            return;
        }
        Inorder(root);
        int tmp = first.val;
        first.val = last.val;
        last.val = tmp;    
    }
    
    private void Inorder(TreeNode root){
        if(root == null){
            return;
        }
        Inorder(root.left);
        if(prev != null && prev.val >= root.val){
            if(first == null){
                first = prev;
                last = root;
                
            }else{
                last = root;
            }
        }
        prev = root;
        Inorder(root.right);
        
        
    }
}