using System;
using System.Collections.Generic;

namespace Algorithms
{
    public class NodeNext
    {
        public int val;
        public NodeNext left;
        public NodeNext right;
        public NodeNext next;

        public NodeNext() { }

        public NodeNext(int _val)
        {
            val = _val;
        }

        public NodeNext(int _val, NodeNext _left, NodeNext _right, NodeNext _next)
        {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
    /// Time Complexity : O(n)
    // Space Complexity :O(n)
    // Did this code successfully run on Leetcode :Yes
    // Any problem you faced while coding this :  Referred Online
    public class PopulatingNextPointer
    {
        public NodeNext Connect_LevelOrder(NodeNext root)
        {
            if (root == null) return root;
            Queue<NodeNext> q = new Queue<NodeNext>();
            q.Enqueue(root);

            while (q.Count != 0)
            {
                NodeNext prev = null;
                int size = q.Count;
                for (int i = 0; i < size; i++)
                {
                    NodeNext curr = q.Dequeue();
                    if (i > 0)
                    {
                        prev.next = curr;
                    }
                    if (curr.left != null)
                    {
                        q.Enqueue(curr.left);
                        q.Enqueue(curr.right);
                    }
                    prev = curr;

                }
            }

            return root;
        }


        public NodeNext Connect(NodeNext root)
        {
            if (root == null) return root;
            NodeNext level = root;
            NodeNext curr = root;
            while (level.left != null)
            {
                curr = level;
                while (curr != null)
                {
                    curr.left.next = curr.right;
                    if (curr.next != null)
                        curr.right.next = curr.next.left;
                    curr = curr.next;
                }
                level = level.left;
            }

            return root;
        }
    }
}
