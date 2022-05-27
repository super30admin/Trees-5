//time - O(n)
//space - O(1)
class Solution {
    public Node connect(Node root) {
        if(root==null) return root;
        Node lvl = root;
        Node curr = lvl;

        while(lvl.left!=null){
            while(curr!=null){
                curr.left.next = curr.right;
                if(curr.next!=null){
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            lvl = lvl.left;
            curr = lvl;
        }

        return root;
    }
}
