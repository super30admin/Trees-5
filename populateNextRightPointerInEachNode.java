
// Level order traversal using BFS
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/*  We need to get the node for every level, so can do a level order traversal to get all elements for every level.
 */
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

        if(root == null )
        {
            return null;
        }

        Queue<Node> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i = 0 ; i < size; i++)
            {
                Node curr  = q.poll();
                if(i != size -1)
                {
                    curr.next = q.peek();
                }
                if(curr.left != null)
                {
                    q.add(curr.left);
                    q.add(curr.right);
                }
            }
        }

        return root;
        
    }
}



//BFS

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/*  We go to every level, take a curr node which will check for next values in that level.
 *  go every new level by taking the left most node for that level
 */
class Solution {
    public Node connect(Node root) {

        if(root == null )
        {
            return null;
        }

        Node level = root;

        while(level.left != null)
        {
            Node curr = level;
            while(curr != null)
            {
                curr.left.next = curr.right;
                if(curr.next != null)
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



//DFS

// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/* we run DFS over the BT, we make connection between left and right and call the dfs recursive function to make connections between the children nodes
 */
class Solution {
    public Node connect(Node root) {

        if(root == null )
        {
            return null;
        }

        dfs(root.left,root.right);
        return root;
    }

    private void dfs(Node left, Node right)
    {
        if(left == null)
            return;
        
        left.next = right;
        dfs(left.left,left.right);
        dfs(left.right, right.left);
        dfs(right.left, right.right);
    }
}






// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/* we run DFS over the BT, we make connection between left and right and call the dfs recursive function to make connections between the children nodes
 */
class Solution {
    public Node connect(Node root) {

        if(root == null )
        {
            return null;
        }

        dfs(root);
        return root;
    }

    private void dfs(Node root)
    {
        if(root.left == null)
            return;
        
        root.left.next = root.right;
        if(root.next != null)
        {
            root.right.next = root.next.left;
        }

        dfs(root.left);
        dfs(root.right);

    }
}