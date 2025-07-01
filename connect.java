class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node(int val) {
        this.val = val;
    }
}

class Solution {
    public Node connect(Node root) {
        if (root == null) return null;

        Node levelStart = root;

        while (levelStart.left != null) {
            Node curr = levelStart;

            while (curr != null) {
                curr.left.next = curr.right;

                if (curr.next != null) {
                    curr.right.next = curr.next.left;
                }

                curr = curr.next;
            }

            levelStart = levelStart.left;
        }

        return root;
    }
}
