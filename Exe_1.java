class Solution {
    public Node connect(Node root) {
        connect(root, null);
        return root;
    }

    private void connect(Node curr, Node next){
        if(curr != null){
            curr.next = next;
            connect(curr.left, curr.right);
            connect(curr.right, next==null ? null : next.left);
        }
    }
}
//tc = O(n)
//sc = O(n)
