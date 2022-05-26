using System;
using System.Collections.Generic;
using System.Text;

namespace BinaryTree
{
    public class RecoverBinaryTree
    {
        /*
         * T.C: O(n) since traversing all the element of the tree
         * S.C: O(h) high of the tree
         */
        TreeNode first;
        TreeNode second;
        TreeNode prev;
        bool flag = false;
        public void RecoverTree(TreeNode root)
        {
            if (root == null) return;

            inorder(root);

            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }

        public void inorder(TreeNode root)
        {
            if (root == null)
                return;

            inorder(root.left);

            if (prev != null && prev.val > root.val)
            {
                if (first == null)
                {
                    first = prev;
                    second = root;
                    flag = true;
                }
                else
                {
                    second = root;
                    flag = false;
                }
            }
            prev = root;
            if (!(flag == false && first != null && second != null))
            {
                inorder(root.right);
            }
        }
    }
}   
