// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :yess
// Any problem you faced while coding this :NO


// Your code here along with comments explaining your approach: Inorder Traversal

class Solution {
    TreeNode prevNode= new TreeNode(Integer.MIN_VALUE);
    TreeNode firstNode= null;
    TreeNode secondNode= null;

    public void recoverTree(TreeNode root) {
        traverse(root);

        int temp= firstNode.val;
        firstNode.val=secondNode.val;
        secondNode.val= temp;
        
    }

    public void traverse(TreeNode Node){
        if(Node==null) return;

        traverse(Node.left);
        if(firstNode==null && prevNode.val>Node.val){
            firstNode=prevNode;
        }
        if(firstNode!=null && prevNode.val>Node.val){
            secondNode=Node;
        }
        prevNode=Node;

        traverse(Node.right);
    }
}