//Time complexity is O(N)
//Space complexity is O(1)
class Solution {
    public Node connect(Node root) {
        
        if (root == null) {
            return root;
        }
        Node leftmost = root;
        
        while (leftmost.left != null) {
            Node head = leftmost;
            
            while (head != null) {
                
                head.left.next = head.right;
                
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                
                head = head.next;
            }
            
            leftmost = leftmost.left;
        }
        
        return root;
    }
}