/*Time Complexity : O(N)
Space Complexity : O(N). Not optimal.
Did it run on LeetCode : Yes
Any Problems? : No.
*/
class Solution {
    public Node connect(Node root) {
        
        if(root==null) return root; // if root null, return root
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty())
        {
            Node current = root;
            current = queue.poll();
            if(current.left!=null && current.right!=null)
            {
                current.left.next = current.right; // Making the left child point to Right child.
                if(current.next!=null)  // This is the case used to connect childs of two different branches. *Very Important case* 
                {
                    current.right.next = current.next.left; // In the given example. Connects 5->6.
                }
                
                queue.offer(current.left); // add left node to queue
                queue.offer(current.right); // add right node to queue.
            }
        }
       return root; 
    }
}