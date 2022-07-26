// Time Complexity : O(n)
// Space Complexity :O(n)

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
            return root;
        Queue<Node> q= new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            Node prev=null;
            for(int i=0;i<size;i++){
                if(prev!=null){
                    Node curr= q.poll();
                    prev.next=curr;
                    prev=curr;
                }
                else{
                    prev=q.poll();
                } 
                if(prev.left!=null){
                    q.add(prev.left);
                    q.add(prev.right);
                }

            }   
        }
            return root;
    }
}