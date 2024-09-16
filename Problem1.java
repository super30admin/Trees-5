//time o(n)
//space o(1)
class Solution {
    public Node connect(Node root) {
        if(root == null)
            return null;
        Node leftPart = root;
        
        while(leftPart.left != null) {
            Node head = leftPart;
            
            while(head != null) {
                //connection1
                head.left.next = head.right;
                
                //connection2
                if(head.next != null)
                    head.right.next = head.next.left;
                head = head.next;
            }
            leftPart = leftPart.left;
        }
        return root;
    }
}