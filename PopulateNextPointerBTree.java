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

class PopulateNextPointerBTree {
    
    /*
      Time : O(N) - N being node in the tree
      Space : O(N/2) ~ O(N) - max n/2 nodes at the leaf in queue 
      Leetcode : YES
    */
    
    /*
      Approach
      1. Do BFS
      2. mark next pointer as front of the que. at each level end do not assign a next pointer
    */
    public Node connect(Node root) {
        // with extra space
        if(root == null) return root;
        
        Queue<Node> que = new LinkedList<>();
        que.add(root);
        
        while(!que.isEmpty()){
            int size = que.size();
            
            while(size > 0){
                Node curr = que.poll();
                if(size > 1)curr.next = que.peek();
                if(curr.left != null) que.add(curr.left);
                if(curr.right != null) que.add(curr.right);
              
                size--;
            }       
        } 
        return root;
    }
}
