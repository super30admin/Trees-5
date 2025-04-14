using System;
using System.Collections.Generic;
using System.Text;

namespace Tree
{
    class PopulatingNextRightPointers
    {
        public class Node
        {
            public int val;
            public Node left;
            public Node right;
            public Node next;

            public Node() { }
            public Node(int _val)
            {
                val = _val;
            }
            public Node(int _val, Node _left, Node _right, Node _next)
            {
                val = _val;
                left = _left;
                right = _right;
                next = _next;
            }
        }
        //TC: O(n)
        //SC: O(n)
        public Node Connect(Node root)
        {
            if (root == null)
            {
                return root;
            }
            Queue<Node> q = new Queue<Node>();
            q.Enqueue(root);
            while (q.Count != 0)
            {
                int size = q.Count;
                Node prev = q.Dequeue();
                if (prev.left != null)
                {
                    q.Enqueue(prev.left);
                    q.Enqueue(prev.right);
                }
                for (int i = 1; i < size; i++)
                {
                    Node curr = q.Dequeue();
                    if (curr.left != null)
                    {
                        q.Enqueue(curr.left);
                        q.Enqueue(curr.right);
                    }
                    prev.next = curr;
                    prev = curr;
                }
            }
            return root;
        }
        //TC:O(n)
        //SC:O(1)
        public Node ConnectOptimized(Node root)
        {
            if (root == null)
            {
                return root;
            }
            Node level = root;
            while (level.left != null)
            {
                Node curr = level;
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
    }
}
