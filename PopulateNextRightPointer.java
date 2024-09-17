//Time O(n)
//Space O(n)
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
        if(root==null) return root;
        bfs(root);
        return root;
    }
    private void bfs(Node root)
    {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) //main loop
        {
            Node prev= null;
            int size= q.size(); //current size of q  each levels size
            for(int i =0;i<size;i++)
            {
                Node val = q.poll();
                if(prev!=null)
                    prev.next= val;
                prev=val;
                if(val.right!=null)   
                {
                q.add(val.left);
                q.add(val.right);
                }
            }
        }
        
    }
}