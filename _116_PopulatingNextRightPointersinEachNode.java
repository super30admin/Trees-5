// Time Complexity : o(n) where n is number of nodes in tree
// Space Complexity : o(h) whre h is the height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// pass parent along with each node, use parent to find the next node of each child
class Solution {
    public Node connect(Node root) {
        preorder(root, null);
        return root;
    }

    public void preorder(Node root, Node parent){

        if(root == null) return;

        Node temp = parent;
        while(temp != null){

            if(temp.left != parent.left && temp.left != null){
                root.next = temp.left;
                break;
            }
            else if(root != temp.right && temp.right != null){
                root.next = temp.right;
                break;
            }
            temp = temp.next;
        }

        preorder(root.left, root);
        preorder(root.right, root);
    }

    /******** sort of same as above, instead of passing parent to the given node, pass its next node and attach the next to the current node
       calculate the next node for left and rght chidren and pass it in recursion *****/
       public Node connect(Node root) {
        preorder(root, null);
        return root;
    }

    public void preorder(Node root, Node next){
        if(root == null) return;
        root.next = next;
        preorder(root.left, root.right);
        preorder(root.right, root.next != null ? root.next.left : null);
    }

    /*** one more logic of maintaining two levele pointers and keep attaching next of current level using prev level pointer***/
    // being used in LC - 117, curr moves 1 time and prev moves 1 time as curr level 2 the number of nodes as prev level.  
}
