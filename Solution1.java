import java.util.*;

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No 
// Your code here along with comments explaining your approach


public class Solution1 {
// Definition for a Node.
    public class Node {
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

    //DFS
// Time Complexity : O(n) touching all nodes at once
// Space Complexity :O(logn) maximum element in the recursive stack
    public Node connect(Node root) {
        if(root==null)
            return root;
        if(root.left!=null)
            dfs(root.left,root.right);
        
        return root;
    }
    
    private void dfs(Node left,Node right){
        
        if(left==null)
            return;
        
        //logic
      left.next=right;
        
    dfs(left.left,left.right);
    dfs(right.left,right.right);
    if(left.next!=null)
        dfs(left.right,right.left);
    
    }
    //BFS
// Time Complexity : O(n) touching all nodes at once
// Space Complexity :O(n) maximum element in the queue will ne n/2
    public Node connect2(Node root) {
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

    //Two pointers
// Time Complexity : O(n) touching all nodes at once
// Space Complexity :O(1) no extra space 
    public Node connect3(Node root) {
        if(root==null)
            return root;
        Node level=root;
        Node curr=root;
        while(level!=null){
            while(curr!=null){
                if(curr.left!=null){
                    curr.left.next=curr.right;
                    if(curr.next!=null)
                curr.right.next=curr.next.left;
                }
                curr=curr.next;
            } 
            level=level.left;
            curr=level;
        }
      
        return root;
    }
}