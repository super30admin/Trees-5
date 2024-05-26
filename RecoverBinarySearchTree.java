
 //Definition for a binary tree node.

import java.util.Stack;

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
    TreeNode second;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode root)
    {
        Stack<TreeNode> st = new Stack<>();

        while(root != null || !st.isEmpty())
        {
            while(root != null)
            {
                st.push(root);
                root = root.left;
            }         
        root = st.pop();

        if((prev != null) && (root.val < prev.val))
        {
            //if it is first breach
            if(first == null)
            {
                first = prev;
                second = root;
            }
            else
            {
                second = root;
            }
        }

        prev = root;
        root = root.right;
    }
    }
}