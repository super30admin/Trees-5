public class Problem1 {
    //t.c-> O(n)
    //s.c-> O(1)
    public Node connect(Node root) {
        if(root == null) {
            return root;
        }
        Node left, curr;
        left = root;

        while(left.left != null) {
            curr = left;
            while(curr != null){
                curr.left.next = curr.right;
                if(curr.next != null){
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            left = left.left;
        }
        return root;
    }
}
