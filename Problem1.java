// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

class Solution {
    // Time complexity : O(N)
    // Space complexity : O(height)
    public Node connect(Node root) {
        if (root == null)
            return null;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            Node right = null;
            for (int i = size - 1; i >= 0; i--) {
                Node child = q.poll();
                child.next = right;
                right = child;

                if (child.right != null)
                    q.add(child.right);
                if (child.left != null)
                    q.add(child.left);
            }
        }
        return root;
    }

    //Recursive Solution

    // Time complexity : O(N)
    // Space complexity : O(height)
    public Node connect(Node root) {
        if (root == null)
            return root;
        traverse(root, 0, new ArrayList<Node>());
        return root;
    }

    public void traverse(Node root, int level, List<Node> l) {
        if (root == null)
            return;

        if (l.size() == level) {
            l.add(root);
        } else {
            root.next = l.get(level);
            l.set(level, root);
        }
        traverse(root.right, level + 1, l);
        traverse(root.left, level + 1, l);
    }
}