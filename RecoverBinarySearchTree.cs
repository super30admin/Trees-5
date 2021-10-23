using System;
using System.Collections.Generic;
using System.Text;

namespace Tree
{
    class RecoverBinarySearchTreeLC
    {
        //TC: O(n)
        //SC: O(H)
        public class TreeNode
        {
            internal int val;
            internal TreeNode left;
            internal TreeNode right;
            TreeNode() { }
            TreeNode(int val) { this.val = val; }
        }
        TreeNode first, last, prev;
        bool mismatch;
        public void RecoverTree(TreeNode root)
        {
            if (root == null)
            {
                return;
            }
            inorder(root);
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        }
        private void inorder(TreeNode root)
        {
            //base
            if (root == null)
            {
                return;
            }

            //logic
            inorder(root.left);
            if (prev != null && prev.val >= root.val)
            {
                if (!mismatch)
                {
                    first = prev;
                    last = root;
                    mismatch = true;
                }
                else
                {
                    last = root;
                    return;
                }
            }
            prev = root;
            inorder(root.right);
        }
    }
}
