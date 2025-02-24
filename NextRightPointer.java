//Time Complexity : O(n)
//Space Complexity : O(n)


class Solution {
    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        Node left = root;
        while(left.left != null){
            Node curr = left;
            while(curr!=null){
                curr.left.next = curr.right;
                if(curr.next!=null){
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            left = left.left;
        }
        return root;
    }
}