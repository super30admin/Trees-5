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

// TC: O(N) , N -> no. of nodes of the tree
// SC: O(1) 
// Did it run successfully on Leetcode? :Yes
class Solution {
    public Node connect(Node root) {
        if ( root == null)
            return null;
        Node level = root;
        while (level.left != null)
        {
            Node curr = level;
            while ( curr != null)
            {
                curr.left.next = curr.right;
                if ( curr.next != null)
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

// DFS
// TC: O(N) , N -> no. of nodes of the tree
// SC: O(H) , H-> height of the tree
// Did it run successfully on Leetcode? :Yes
class Solution {
    public Node connect(Node root) {
        if ( root == null)
            return null;
        dfs(root.left, root.right);
        return root;
    }
    private void dfs(Node left, Node right)
    {
        //base
        if ( left == null && right == null)
            return;
        //logic
        left.next = right;
        dfs(left.left, left.right);
        dfs(left.right, right.left);
        dfs(right.left, right.right);
    }
}

// TC: O(N) , N -> no. of nodes of the tree
// SC: O(N) , size of queue -> no. of nodes of the tree
// Did it run successfully on Leetcode? :Yes
// class Solution {
//     public Node connect(Node root) {
//           if ( root == null)
//             return null;
//         Queue<Node> q = new LinkedList();
//         q.offer(root);
//         while (!q.isEmpty())
//         {
//             int size = q.size();
//             Node prev = q.poll();
//             if (prev.left != null)
//             {
//                 q.offer(prev.left);
//             }
//             if (prev.right != null)
//             {
//                 q.offer(prev.right);
//             }
//             for ( int i = 1; i < size; i++)
//             {    
//                Node curr = q.poll();
//                  if (curr.left != null)
//                  {
//                   q.offer(curr.left);
//                  } 
//                  if (curr.right != null)
//                  {      
//                      q.offer(curr.right);
//                  }
//                prev.next = curr;
//                prev = curr;
//             }
//         }
//         return root;
//     }
// }
