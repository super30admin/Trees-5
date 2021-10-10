// BFS without queue: TC: O(n), SC: O(1)
class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        Node level = root; // track when out of bounds
        Node curr = root;
        while(level.left != null) {
            curr = level;
            while(curr != null) {
                curr.left.next = curr.right;
                if(curr.next != null)
                    curr.right.next = curr.next.left;
                curr = curr.next;
            }
            level = level.left;
        }
        return root;
    }
}