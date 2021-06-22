// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

//Time Complexity : O(n) since we are traversing across all the nodes in the tree in worst case scenario
//Space Complexity: O(n) since we are taking queue for level by level traversal

class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
    
        Queue<Node> q = new LinkedList<>();
        q.add(root);      
        while(!q.isEmpty()){
            int size = q.size();
            Node prev = q.poll();
            
            if(prev.left != null){ // Since perfect binary tree 
                q.add(prev.left); 
                q.add(prev.right);
            }
            Node curr;
            for(int i = 1; i < size ; i++){
                curr = q.poll();
                prev.next = curr;                
                if(curr.left != null){ 
                    q.add(curr.left);
                    q.add(curr.right);
                }
                prev = curr;
            } 
        }
        return root;
    }
}