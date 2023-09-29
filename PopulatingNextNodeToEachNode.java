import java.util.LinkedList;
import java.util.Queue;

import org.w3c.dom.Node;

//tc = O(n)
//sc = O(n)
class Solution {
    public Node connect(Node root) {
        if (root == null)
            return root;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node prev = null;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                if (i != 0) {
                    prev.next = curr;
                }
                if (curr.left != null) {
                    q.add(curr.left);
                    q.add(curr.right);
                }

                prev = curr;

            }
        }
        return root;

    }
}
