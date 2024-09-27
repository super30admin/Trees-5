// Time Complexity : 0(n)
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 

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

class RightPointer {
    public Node connect(Node root) {
        if(root == null)
            return root;
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int level = q.size();
            for(int i=0;i<level;i++){
                Node tmp = q.poll();
                if(i < level - 1)
                    tmp.next = q.peek();
                if(tmp.left != null)
                    q.add(tmp.left);
                if(tmp.right != null)
                    q.add(tmp.right);
            }
        }

        return root;
    }
}