public class NextRightPointers {


    /*
    TC : O(N) where N is the number of nodes
    SC : O(N) where N is the number of nodes
    LC : yes
    problems : No
     */

    /**
     * The approach is to perform BFS and use the queue size to identify the nodes at a particular level.
     * Also make sure to not update the next pointer of the last node at a particular level
     */
    public Node connect(Node root) {

        if (root == null) {
            return root;
        }

        Queue<Node> Q = new LinkedList<Node>();
        Q.add(root);


        while (Q.size() > 0) {

            int size = Q.size();

            for (int i = 0; i < size; i++) {

                Node node = Q.poll();

                if (i < size - 1)
                    node.next = Q.peek();


                if (node.left != null)
                    Q.add(node.left);

                if (node.right != null)
                    Q.add(node.right);

            }
        }

        return root;
    }
}


