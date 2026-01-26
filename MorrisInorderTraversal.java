// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// At every node, we try to find its inorder predecessor. 
//  We link the predecessor's right to the current node and move to left child of current node.
//  If left child is null, we add reached the smallst node and add to result;
//  Upwards traversal noted by pre.right != curr and we break the link to preserve the original tree
// If we move downward we make the link 

class Solution {
     public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList();
        TreeNode curr = root;
        while(curr != null){
            if(curr.left == null){
                result.add(curr.val);
                curr = curr.right;
            } else{
                TreeNode pre = curr.left;
                while(pre.right != null && pre.right != curr)
                    pre = pre.right;

                if(pre.right == null){
                    pre.right = curr;
                    curr = curr.left;
                } else{
                    pre.right = null;
                    result.add(curr.val);
                    curr = curr.right;
                }
            }
            
        }
        return result;
    }
}