public class RecoveryBinaryTree {
    Node previous = null;
    
    Node first = null;
    Node last = null;
    
    boolean isFirst = false;

    //TC: O(N) 
    //SC: O(N) recursive stack
    public void recoverTree(Node root) {
        //Inorder traversal
        //Left
        //Condition
        //Right

        //Two pointers. Previous and Current
        //If it occurs first breach - Capture the first node s the previous one.
        //If it occurs second time - capture the current node. 
        //Replace just values.

        helper(root);
        
        int value = first.val;
        first.val = last.val;
        last.val = value;
    }
    
    private void helper(Node root) {
         if(root == null) return;
        
        helper(root.left);
        if(previous!=null && previous.val >= root.val) {
            if(!isFirst) {
                first = previous;
                last = root;
                isFirst = true;
            } else {
                last = root;
            }
        }
        previous = root;
        helper(root.right);
    }
}
