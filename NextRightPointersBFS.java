//TC : O(N) N number of nodes in the tree
//SC : O(2^h) where h is the height of the tree, size of the queue
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
            return null;
        Queue<Node> queue = new LinkedList<>();
        Queue<Node> queue2= new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
             Node prev = null;
            while(size>0){
                Node node = queue.poll();
                if(prev!=null)
                    prev.next = node;
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
                prev = node;
    
                size--;
            }
            
        
        }
        
        return root;
    }
}