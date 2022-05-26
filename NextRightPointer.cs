using System;
using System.Collections.Generic;
using System.Text;

namespace BinaryTree
{
    class NextRightPointer
    {
        /*
         * T.C: O(N) since traversing all the nodes
         * S.C: O(1) no extra space used
         */
        public TreeNode Connect(TreeNode root)
        {
            if (root == null) return null;

            TreeNode level = root;


            while (level.left != null)
            {
                TreeNode curr = level;
                while (curr != null)
                {
                    curr.left.next = curr.right;
                    if (curr.next != null)
                    {
                        curr.right.next = curr.next.left;
                    }
                    curr = curr.next;
                }
                level = level.left;
            }

            return root;
        }


        //Method2
        /* T.C: O(n) since traversing all the nodes
         * S.C: O(h) hight of the tree
         */
        public TreeNode Connect1(TreeNode root)
        {
            if (root == null) return null;
            Queue<TreeNode> q = new Queue<TreeNode>();
            q.Enqueue(root);

            while (q.Count != 0)
            {
                int size = q.Count;
                TreeNode curr = q.Dequeue();

                if (curr.left != null)
                {
                    q.Enqueue(curr.left);
                }
                if (curr.right != null)
                {
                    q.Enqueue(curr.right);
                }

                for (int i = 1; i < size; i++)
                {
                    TreeNode temp = q.Dequeue();
                    curr.next = temp;
                    curr = temp;

                    if (curr.left != null)
                    {
                        q.Enqueue(curr.left);
                    }
                    if (curr.right != null)
                    {
                        q.Enqueue(curr.right);
                    }
                }
            }
            return root;
        }
    }
}
