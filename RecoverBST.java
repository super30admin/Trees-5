

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

 //recursion
 /*
class Solution {
    TreeNode prev;
    TreeNode first;
    TreeNode sec;
    public void recoverTree(TreeNode root) {
        inorder(root);
        int t=sec.val;
        sec.val=first.val;
        first.val=t;
    }

    private void inorder(TreeNode root){
        if(root==null){
            return;
        }

        inorder(root.left);
        TreeNode curr=root;
        if(first==null && prev!=null && curr.val< prev.val){
            first=prev;
        }
        if(prev!=null && curr.val<prev.val && first!=null){
            sec=curr;
        }
        prev=root;
        inorder(root.right);
    }
}*/

//iterative
//TC(O(n))
//SC(O(logn))
class RecoverBST {
    
    public void recoverTree(TreeNode root) {
        TreeNode prev=null;
        TreeNode first=null;
        TreeNode sec=null;
        Stack<TreeNode> stk=new Stack<>();
        while(!stk.isEmpty() || root!=null){
            while(root!=null){
                stk.push(root);
                root=root.left;
            }
            root=stk.pop();
            if(first==null && prev!=null && root.val< prev.val){
                first=prev;
            }
            if(prev!=null && root.val<prev.val && first!=null){
                sec=root;
            }
            prev=root;
            root=root.right;
        }
        int t=sec.val;
        sec.val=first.val;
        first.val=t;
    }
}