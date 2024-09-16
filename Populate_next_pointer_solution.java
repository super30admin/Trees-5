package trees;

public class Populate_next_pointer_solution {
//	O(1) -> SPC (ignore r-stack)
//	O(N) -> TC
    public Node connect(Node root) {
        if(root==null) return null;
        
        dfs(root.left,root.right);
        
        return root;
    }
    
    
    
    private void dfs(Node left, Node right){
        if(left==null && right==null) return;
        
        
        
        left.next=right;
        
        dfs(left.left,left.right);
        dfs(left.right,right.left);
        dfs(right.left,right.right);
        
    }

    
    
    
    
    //approach 2
    
    
    
    
    
    public Node connect(Node root) {
        // O(n) -->tc
        // O(1)-->sc
        
        if(root==null) return null;
        
        Node level=root;
        // Node curr=root;
        
        
        while(level.left!=null){
            
            Node curr=level;
           
            
            while (curr!=null){
                
                 curr.left.next=curr.right;
                
                if(curr.next!=null) curr.right.next=curr.next.left;
                
                curr=curr.next;
            }
            
            
           
            
            level=level.left;
            
            
        }
        
        
       
        
        return root;
        
        
        
    }

    
    
}
