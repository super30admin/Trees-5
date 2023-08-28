public class PopulatingNextRightPointersDFSSingleNodeRecursion {

        // DFS Recursion - on single node

        public Node connect(Node root) {

            if(root == null)     return null;

            dfs(root);

            return root;
        }

        private void dfs(Node root) {

            //base
            if(root.left == null) return;

            //logic
            //action
            // stand on roof and make connections on floor

            //first next pointer must be pre-order
            // if first next pointer is not made pre-order, root.next will always be null
            root.left.next = root.right;

            // the following next pointers can be in pre-order or in-order
            if(root.next != null) {

                root.right.next = root.next.left;
            }

            dfs(root.left);

            // above two next pointer connections must be made before dfs call on right child
            // otherwise, it will be discontinuous
            dfs(root.right);
        }

}

/*
TIME COMPLEXITY = O(N)
traversed all nodes

SPACE COMPLEXITY = O(H) = O(N)
recursive stack space
*/
