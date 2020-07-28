class Solution {
        // Time Complexity : O(N) N: nodes of Tree
// Space Complexity : O(N)  N+ h h:for dummy nodes;   queue space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

 /* 
 Iterative:
 1. Use a queue for storing nodes with dummy node as separator of levels
 */
    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> q = new LinkedList<Node>();
        Node dummy = new Node(10000);
        q.add(root);
        q.add(dummy);
        while(q.size()>1){
            Node curr_node = q.poll();
            if(curr_node.val != 10000){
                if(curr_node.left!=null)
                    q.add(curr_node.left);
                if(curr_node.right!=null)
                    q.add(curr_node.right);
                if(q.peek() == dummy)
                    curr_node.next = null;
                else
                    curr_node.next = q.peek();
            }
            else{
                q.add(dummy);
            }            
        }
      return root;
    }
}




class Solution {
        // Time Complexity : O(N) N: nodes of Tree
// Space Complexity : O(N)     queue space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

 /* 
 Iterative:
 1. Use a queue for storing nodes without dummy node as separator of level
 */
    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while(q.size()>0){
            int size = q.size();
            for(int i =0; i<size;i++){
                Node curr_node = q.poll();
                if(i != size-1) curr_node.next = q.peek();
                else curr_node.next = null;
                if(curr_node.left!=null)
                    q.add(curr_node.left);
                if(curr_node.right!=null)
                    q.add(curr_node.right);
            }                             
        }
      return root;
    }
}







class Solution {
        // Time Complexity : O(N) N: nodes of Tree
// Space Complexity : O(1)     if recursive stack space is ignored
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

 /* 
 Postorder:
 1. Use postorder traversal and keep updating the left and right child's next pointers.
 */
    public Node connect(Node root) {
        if(root == null) return null;
        postOrder(root);
        
        return root;
    }
    private void postOrder(Node root){
        if(root.left == null && root.right == null) return;
        
        root.left.next = root.right;
        if(root.next!=null)
            root.right.next = root.next.left;
        postOrder(root.left);
        postOrder(root.right);
    }
}