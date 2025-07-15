// Time Complexity -> O(n)
// Space Complexity -> O(1);
class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        Node level = root;
        Node curr = root;
        while(level != null){
            while(curr != null && curr.left != null){
                curr.left.next = curr.right;
                if(curr.next != null){
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            level = level.left;
            curr = level;
        }
        return root;
    }
}
