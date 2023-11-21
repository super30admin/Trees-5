

// Time Complexity :O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public Node connect(Node root) {
      if (root == null) {
            return root;
        }
    Queue<Node> q = new LinkedList<>();
    q.add(root);  
    while(!q.isEmpty()){
    int size = q.size();  
    for(int i = 0; i <size; i++){
    Node curr = q.poll();
    if(i<size-1) curr.next = q.peek();
    
    if(curr.left != null) q.add(curr.left);
    if(curr.right != null) q.add(curr.right);
    }
    
    } 
    return root;
    }
}
