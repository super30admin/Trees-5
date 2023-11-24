public class MorrisInorderTraversal
	{
        // Time Complexity : O(n), n nodes in tree
        // Space Complexity : O(1) - along with recursive stack space
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No

        IList<int> result;
        public IList<int> InorderTraversal(TreeNode root)
        {
            result = new List<int>();
            helper(root);
            return result;
        }

        public void helper(TreeNode root)
        {
            TreeNode curr = root;

            while(curr != null)
            {
                if(curr.left == null)
                {
                    result.Add(curr.val);
                    curr = curr.right;
                }
                else
                {
                    TreeNode pred = curr.left;
                    while(pred.right != null || pred.right == curr)
                    {
                        pred = pred.right;
                    }
                    if(pred.right == curr)
                    {
                        pred.right = null;
                        result.Add(curr.val);
                        curr = curr.right;
                    }
                    else
                    {
                        pred.right = curr;
                        curr = curr.left;
                    }
                }
            }
        }
    }
