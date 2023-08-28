public class RecoverBSTTwoBreachInOrderRecursion {

        // Exactly two node breaches - Recursive Inorder traversal - O(H) space
        // If there are more breaches, just sort in Inorder list and make tree again

        // global pointers
        TreeNode breachOne;
        TreeNode breachTwo;
        TreeNode prev;

        public void recoverTree(TreeNode root) {

            if(root == null) return;

            // in order recursion
            inOrder(root);      // O(H) space

            // swap two breaches
            // only values swapped, not tree nodes which will result in swapping subtrees and that is not the intention
            int temp = breachOne.val;
            breachOne.val = breachTwo.val;
            breachTwo.val = temp;
        }

        private void inOrder(TreeNode root) {   // O(N)

            //base
            if(root == null) return;

            // logic
            inOrder(root.left);

            // inorder action
            if(prev != null && prev.val >= root.val) {

                //breach one not reached yet
                if(breachOne == null) {

                    // first swap value will be of prev
                    breachOne = prev;

                    // if there is only child-parent breach pair
                    breachTwo = root;
                }
                // breach one reached already
                else {
                    //second swap value will be of root
                    breachTwo = root;
                }
            }

            // keep moving prev along with root irrespective of breaches
            prev = root;

            inOrder(root.right);


        }

}

/*
TIME COMPLEXITY = O(N)
SPACE COMPLEXITY = O(H) = O(N)

N = number tree nodes in binary tree
H = height of tree
*/

