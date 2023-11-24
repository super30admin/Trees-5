public class RecoverBST
	{

        // Time Complexity : O(n) - have to traverse all nodes
        // Space Complexity : O(h)
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No
        TreeNode prev;
        TreeNode first;
        TreeNode second;
        public void RecoverTree(TreeNode root)
        {
            if (root == null)
                return;
            inorder(root);
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
        private void inorder(TreeNode root)
        {
            //base
            if (root == null)
                return;

            //logic
            inorder(root.left);
            if(prev != null && root.val <= prev.val)
            {
                //first breach
                if(first == null)
                {
                    first = prev;
                    second = root;
                }
                //second breach
                else
                {
                    second = root;
                }
            }
            prev = root;
            inorder(root.right);
        }
    }
