// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach :
/*
 * 1 - BFS
 * 
 */
public class NextPointer {
    public Node connect(Node root) {
        if(root == null)
            return root;
        
        Queue<Node> q = new LinkedList<>();
        Node prev = null;
        
        q.add(root);
        
        while(!q.isEmpty())
        {

            int size = q.size();
            for(int i = 0; i<size;i++)
            {
                Node curr = q.poll();
                if(i != 0)
                {
                    prev.next = curr;
                }
                prev = curr;
                
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

/*
 * Approach 2 - Using previously established next pointers
 * 1 - The idea is to not use a queue since it is not needed. 
 * 2 - Queue under the hood is a Linked List. 
 * 3 - Most optimized solution
 * TC - O(n)
 * SC - O(1)
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
        if(root == null)
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

/*
 * Approach 3 - DFS
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
        if(root == null)
            return root;
        dfs(root);
        return root;
    }
    public void dfs(Node root)
    {
        //base
        if(root.left == null)
        {
            return;
        }
        //logic
        root.left.next = root.right;
        if(root.next != null)
        {
            root.right.next = root.next.left;
        }
        dfs(root.left);
        dfs(root.right);
    }
}