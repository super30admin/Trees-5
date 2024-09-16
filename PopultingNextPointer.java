/**
 * Algo # for every node, check if there is a next ptr if so make a connection between its right node and next ptrs left
 *      # after that recurse on its left and right nodes
 *
 *      Time: O(n) n-all nodes
 *      Space: O(h) height of the tree
 */
class Solution {

    public Node connect(Node root) {

        if(root == null) return root;

        recurse(root);

        return root;

    }

    private void recurse(Node root){

        if(root == null) return;

        if(root.left != null) {

            root.left.next = root.right;

            if(root.next != null){

                root.right.next = root.next.left;

            }

        }

        recurse(root.left);

        recurse(root.right);

    }

}