//Time Complexity: O(n)
//Space Complexity: O(n)
//Code run successfully on LeetCode.

public class Problem1_1 {

    public Node connect(Node root) {
        
        if(root == null)
            return null;
        
        Queue<Node> q = new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty()){
            
            int size = q.size();
            Node curr = q.poll();
            
            if(curr.left != null)
            {
                q.add(curr.left);
                q.add(curr.right);
            }
            
            for(int i =1; i < size; i++){
                
                Node next = q.poll();
                
                curr.next = next;
                
                if(next.left != null)
                {
                    q.add(next.left);
                    q.add(next.right);
                }
                
                curr = next;
            }
        }
        return root;
    }
}
