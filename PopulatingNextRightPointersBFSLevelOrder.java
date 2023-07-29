import java.util.Queue;
import java.util.LinkedList;

public class PopulatingNextRightPointersBFSLevelOrder {

        //Level order traversal or Breadth First Search - O(N) time and O(N) space

        public Node connect(Node root) {

            if(root == null) return null;

            Queue<Node> q = new LinkedList<>();   // O(D)

            q.add(root);

            // bfs
            while(!q.isEmpty()) {            // O(N)

                int sizeQ = q.size();

                // iterate over each level
                for(int i = 0; i < sizeQ; i++) {

                    Node curr = q.poll();

                    //to avoid null pointer exception when curr is de-referenced
                    if(curr != null) {

                        // keep next pointers for all nodes except the last in a level
                        if(i != sizeQ - 1) {

                            curr.next = q.peek();
                        }

                        // add popped current node's children to bfs queue
                        if(curr.left != null) {

                            q.add(curr.left);

                            //perfect binary tree, so right child exists if left exists
                            q.add(curr.right);
                        }
                    }
                }
            }
            // output root node
            return root;
        }

}

/*
TIME COMPLEXITY = O(N)
SPACE COMPLEXITY = O(D) = O(N)

N = Number of Nodes
D = Diameter of tree = N/2 at last level
*/

