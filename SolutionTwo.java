// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :nopes

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

/*class Solution {
    public Node connect(Node root) {

        if(root==null)
            return root;

        Queue<Node> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty())
        {
            int size = q.size();

            for(int i=0;i<size;i++)
            {
                Node curr = q.poll();

                if(i!=size-1)
                {
                    curr.next = q.peek();
                }

                if(curr.left!=null)
                {
                    q.add(curr.left);
                    q.add(curr.right);
                }


            }

        }
        return root;
    }
}*/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {

        if(root==null)
            return null;

        Node level = root;

        while(level.left!=null)
        {
            Node curr = level;

            while(curr!=null)
            {
                curr.left.next = curr.right;

                if(curr.next!=null)
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


