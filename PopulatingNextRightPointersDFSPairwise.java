public class PopulatingNextRightPointersDFSPairwise {

        //DFS Recursion - O(N) time and O(H) space - establish pairwise next pointer of nodes

        public Node connect(Node root) {

            if(root == null) return null;

            dfs(root.left, root.right);

            return root;

        }

        private void dfs(Node left, Node right) {  //O(N)

            // base
            // right is also null if left is null in a perfect binary tree
            // if next connection is already made, return to parent - Optimization as three dfs call executions happen at every call otherwise
            if(left == null || left.next == right) return;

            // logic
            // action
            left.next = right;

            // recursion
            dfs(left.left, left.right);  // O(H) space
            dfs(left.right, right.left);
            dfs(right.left, right.right);
        }

}


/*
TIME COMPLEXITY = O(N)
traversed all nodes

SPACE COMPLEXITY = O(H) = O(N)
recursive stack space
*/
