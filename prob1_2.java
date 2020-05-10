//TC:O(N)
//SC:O(1)

class Solution {
    public Node connect(Node root) 
    {
        if(root==null) return root;
        Node t = root;
        while(t!=null && t.left!=null){
            Node cur = t;
        while(cur!=null)
        {
           cur.left.next=cur.right;
           if(cur.next!=null)
               cur.right.next = cur.next.left;
           cur=cur.next;  
            
        }
            t=t.left;
        }
        
      return root;  
    }
}