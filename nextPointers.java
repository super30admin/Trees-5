//Time O(n)
//Space O(1)

class Solution {
    public Node connect(Node root) {
        if(root==null)
            return null;
        Node temp = root;
        while(temp.left!=null){
            Node head = temp;
            while(head!=null){
                head.left.next = head.right;
                if(head.next!=null){
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            temp = temp.left;
        }
        return root;
    }
}

