// Time Complexity : O(n)  
// Space Complexity : O(n), queue size
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// this would be the bruteforce level oreder traversal to connect the nodes
// uses extra space of O(n) for queue

class Solution {
    public Node connect(Node root) {
        if(root==null) return root;
        
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            Node cur = null, prev = null;
            
            for(int i=0; i<size; i++){
                cur = queue.poll();
                
                if(cur.left!=null){
                    queue.offer(cur.left);
                }
                if(cur.right!=null){
                    queue.offer(cur.right);
                }
                
                if(prev!=null){
                    prev.next = cur;
                }
                prev = cur;
            }
            
            cur.next= null;
        }
        
        return root;
    }
}