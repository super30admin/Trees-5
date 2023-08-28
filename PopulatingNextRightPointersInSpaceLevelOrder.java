public class PopulatingNextRightPointersInSpaceLevelOrder {

        // In Space - Using previously established next pointers - O(N) time and O(1) space

        public Node connect(Node root) {

            //null case
            if(root == null)  return null;

            // begin from root level
            Node level = root;

            // traverse all levels
            while(level.left != null) {          // O(N)

                Node curr = level;               // O(1) space

                // traverse a level fully
                while(curr != null) {

                    // establishing the first next pointer in a level
                    curr.left.next = curr.right;

                    if(curr.next != null) {

                        // establishing the following next pointers in a level
                        curr.right.next = curr.next.left;
                    }

                    // move to next pointer of current level
                    curr = curr.next;
                }
                //move to next level
                level = level.left;
            }
            //output
            return root;
        }

}

/*
TIME COMPLEXITY = O(N)
traversed all nodes

SPACE COMPLEXITY = O(1)
only pointers used
*/
