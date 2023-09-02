// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
// It is travesal, where we won't be using stack. We will use a current pointer to traverse through the entire node. 
// The rightmost node of the left subtree will be the predecessor. We will make the connection between the predecessor 
// and the root. Then we will print the predecessor and remove the connection
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        TreeNode curr=root;
        while(curr!=null)
        {
            if(curr.left==null)
            {
                result.add(curr.val); //add the left node to the result
                curr=curr.right;
            }
            else
            {
                TreeNode pre=curr.left;
                while(pre.right!=null && pre.right!=curr)
                {
                 pre=pre.right; //We will keep moving to the rightmost node for the left curr pointer
                }

                if(pre.right==null)
                {
                    pre.right=curr; //connect the predecessor to the root node
                    curr=curr.left; //After connecting, move the curr pointer to the next left node;
                }
                else
                {
                    result.add(curr.val);   //add the current value to the result, i.e the root value
                    curr=curr.right;    //since the root is added,move to the right node of the curr pointer
                    pre.right=null;     //remove the connection
                }
            }
        }
        return result;
    }
}