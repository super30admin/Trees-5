//TC - O(N);
//SC - O(N);
//LC - 116
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
        root.next=null;
        helper(root);
        return root;
    }
    public void helper(Node root){
        if(root == null) return;
        
        if(root.left!=null) root.left.next = root.right;
        
        if(root.right!=null) root.right.next = (root.next !=null)?root.next.left : null;
        
        helper(root.left);
        helper(root.right);
    }
}





class Solution {
    public Node connect(Node root) {
        Queue<Node> q = new LinkedList<>();
        
        if(root==null) return root;
        
            
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                Node curr = q.poll();
                if(i==size-1){
                    curr.next=null;
                }
                else{
                    curr.next = q.peek();
                }
                
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            
            

        }
        
        return root;
    }
    

}