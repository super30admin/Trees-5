//Leetcode 116. Populating Next Right Pointers in Each Node
//Time Complexity: O(n) , n is no of nodes in the tree
//Space Complexity: O(1) , As stack space is not be counted as extra space(mentioned in que) 
class Solution {
    public Node connect(Node root) {
        if(root==null) return root;        
        helper( root);
        return root;
        
    }
    public void helper(Node root) {
        if(root==null || root.left==null || root.right==null) return;      
        root.left.next= root.right;
        if(root.next!=null) root.right.next= root.next.left;
        helper(root.left);        
        helper(root.right);
        
            
    }
}


==================================
//BFS solution
//Time Complexity: O(n) , n is no of nodes in the tree
//Space Complexity:O(n), space used for queue

class Solution {
    public Node connect(Node root) {
        if(root==null) return root;
        
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()){
           int s= q.size();
           Node prev=null;
           while(s>0){
               Node n= q.poll();  
               if(n.left!=null) q.offer(n.left);
               if(n.right!=null) q.offer(n.right);
               if(prev!=null) prev.next=n;
               prev=n;
               s--;
            }
        }
        return root;
        
    }
}