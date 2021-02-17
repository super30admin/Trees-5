//Problem 104: Populating Next Right Pointers in Each Node
//TC:O(N)
//SC:O(1), without using stack



class Solution104 {
    
    class Node{
        Node left,right,next;
    }

    //As this is prefect binary tree: all the nodes are at same level
    //We can save usage of stack
    
    //----------Solution 1 Optimised without using stack-----------//

    //TC:Although we will not be traversing last level, however we will say the TC:O(N)
    //SC:O(1), without using stack
    
    public Node connect(Node root) {
        
        if(root==null) return null;
        
        Node curr = root;
        
        while(curr.left!=null){
            
            Node nextLevel = curr.left;
            
            while(curr!=null){
                
                //attach right to left next
                curr.left.next = curr.right;
                
                if(curr.next!=null){//Dry Run example, when u r at mid level, u will understand y that check is required
                    curr.right.next = curr.next.left;
                 }  
                
                curr = curr.next;
            }
            
            curr = nextLevel;
            
        }
        
        return root;
        
    }
    
    //---------Solution 2------------//

    //TC:O(N)
    //SC:O(H), height of recursive stack
    /*public Node connect(Node root) {
        
        if(root==null) return root;
        
        helper(root.left,root.right);
        
        return root;
    }
    
    private void helper(Node left, Node right){
        
        if(left==null) return;
        
        left.next = right;
        helper(left.left,left.right);
        helper(left.right,right.left);
        helper(right.left,right.right);
    }*/
    
    //------------Solution 3 --Bruteforce  ----------------//
    /*
    TC:O(N)
    SC:O(N) for queue
    public Node connect(Node root) {
        
        if(root==null) return null;
        //TC:O(N)
        //SC:O(N/2)=> O(N)
        
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()){
            
            int size = q.size();
            Node prev=null;
            for(int i=0;i<size;i++){
                
                Node curr = q.poll();
                
                if(prev!=null) prev.next = curr;
                //move prev pointer
                prev = curr;
                
                if(curr.left!=null) q.offer(curr.left);
                
                if(curr.right!=null) q.offer(curr.right);
                
            }
            
        }
        
        return root;
    }*/
}