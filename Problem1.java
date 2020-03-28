// Problem1 Populating Next Right Pointers in Each Node(https://leetcode.com/problems/populating-next-right-pointers-in-each-node/)
//Level order traversal
// Time - O(n)
// Space - O(n)
class Solution {
    public Node connect(Node root) {
       if(root == null)
           return null;
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            Node prev = null;
            Node curr = null;
            for(int i = 0; i < size; i++){
                curr = q.poll();
                if(prev != null) 
                    prev.next = curr;
                if(curr.left != null)
                    q.add(curr.left);
                if(curr.right != null)
                    q.add(curr.right);
                prev = curr;
            }
            curr.next = null;
            
        }
        
        return root;
    }
    
    
}