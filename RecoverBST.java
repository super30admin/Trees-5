// TC: O(n)
// SC: O(h)

class Solution {
    TreeNode prev; //to identify place of breach
    TreeNode first, second; // to note down the breach

    public void recoverTree(TreeNode root) {
       Stack<TreeNode> st = new Stack<>();
       while(!st.isEmpty() || root !=null ) {
        while(root != null) {
            st.push(root); // we cannot process the root first as it is inorder traversal so push it into the stack
            root = root.left;
        }
        // Traverse to the leftmost node, pushing nodes onto the stack.
        root = st.pop(); // now, we are the leftmost element and its root.left is null

        if(prev != null && prev.val >= root.val){ // then this is the place of breach
            if(first == null) { // how to  identify if it is first breach or second
                first = prev;
                second = root;
            } else {
                second = root; // if it happens on second
            }
        }
        prev = root;

        root = root.right;
       }

       int temp = first.val;
       first.val = second.val;
       second.val = temp;
    }
}