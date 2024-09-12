// Time Complexity : o(n)
// Space Complexity : 0(L)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public Node connect(Node root) {
        
        if(root==null)
            return root;
        
        Queue<Node> queue=new LinkedList<>();
         queue.add(root);
        
        while(!queue.isEmpty())
        {
             int size=queue.size();
            Node prev=queue.poll();
           
            
            if(prev.left!=null)
            {
                queue.add(prev.left);
                queue.add(prev.right);
            }
            
            for(int i=1;i<size;i++)
            {
                Node curr=queue.poll();
                prev.next=curr;
                
                if(curr.left!=null)
                {
                    queue.add(curr.left);
                    queue.add(curr.right);
                }
                
                prev=curr;
            }
        }
        return root;
    }
}