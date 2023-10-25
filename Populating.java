class Solution {
    public Node connect(Node root) {
        if(root == null){
            return root;
        }
        Node left = root;
        Node curr = null;
        while(left.left != null){
            curr = left;
            while(curr != null){
                curr.left.next = curr.right;
                if(curr.next != null){
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            left=left.left;
        }
        return root;
    }
}
//populating next right pointers in each node