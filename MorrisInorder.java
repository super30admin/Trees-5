// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class MorrisInorder {
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if(root == null)
                return result;

            TreeNode curr = root;
            while(curr != null){
                if(curr.left == null){
                    result.add(curr.val);
                    curr = curr.right;
                }
                else{
                    TreeNode pre = curr.left;
                    while(pre.right != null && pre.right != curr){
                        pre = pre.right;
                    }
                    if(pre.right == null){
                        pre.right = curr;
                        curr = curr.left;
                    }
                    else{
                        pre.right = null;
                        result.add(curr.val);
                        curr = curr.right;
                    }
                }
            }

            return result;
        }
    }
}
