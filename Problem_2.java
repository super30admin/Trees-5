// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
  //store the inorder traversal of and then find out the two nodes and swap them.

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
    List<TreeNode> list;
    public void recoverTree(TreeNode root) {
        list=new ArrayList<>();
        dfs(root);
        TreeNode firstElement=null;
        TreeNode secondElement=null;
        
        TreeNode prev=list.get(0);
        for(int i=1;i<list.size();i++){
            if(prev.val>list.get(i).val && firstElement==null){
                firstElement=prev;
            }
            if(prev.val>list.get(i).val && firstElement!=null){
                secondElement=list.get(i);
            }
            prev=list.get(i);
        }
        // System.out.println(firstElement.val);
        // System.out.println(secondElement.val);
        int temp=firstElement.val;
        firstElement.val=secondElement.val;
        secondElement.val=temp;
    }
    
    public void dfs(TreeNode node){
        if(node==null){
            return;
        }
        dfs(node.left);
        list.add(node);
        dfs(node.right);
    }
}

//The below solution didn't work as there can be invalid subtree.
class Solution {
    public void recoverTree(TreeNode root) {
        dfs(root);
    }
    
    public void dfs(TreeNode node){
        if(node==null){
            return;
        }
        if(node.left!=null && node.left.val>node.val){
            int temp=node.val;
            node.val=node.left.val;
            node.left.val=temp;
        }
        if(node.right!=null && node.right.val<node.val){
            int temp=node.val;
            node.val=node.right.val;
            node.right.val=temp;
        }
        dfs(node.left);
        dfs(node.right);
    }
}