import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class RecoverBST {

    // Inorder traversal
    // TC: O(n)
    // SC: O(h)
    TreeNode first, second, prev;
    boolean flag;
    public void recoverTree(TreeNode root) {
        if(root == null) return;

        inorder(root);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode root) {
        if(root == null) return;

        inorder(root.left);

        if(prev != null && prev.val >= root.val) {
            if(first == null){
                first = prev;
            }
            second = root;
        }
        prev = root; // update prev to point to root
        inorder(root.right);
    }


    /**
     * Optimized approach where we'll go for the right recursion only if we don't have first and second
     * @param root
     */
    private void inorder2(TreeNode root) {
        if(root == null) return;

        inorder(root.left);

        if(prev != null && prev.val >= root.val) {
            if(first == null){
                first = prev;
                second = root;
                flag = true;
            }else {
                second = root;
                flag = false;
            }

        }
        prev = root; // update prev to point to root

        if(!(!flag && first != null && second != null)) {
            inorder(root.right);
        }

    }

    // Using stack approach
    // TC : O(n)
    // SC : O(h)
    public void recoverTreeIterative(TreeNode root) {
        if(root == null) return;

        TreeNode first = null, second = null, prev = null;

        Stack<TreeNode> stack = new Stack<>();

        // General pattern of Iterative inorder traversal begins here
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // General pattern of Iterative inorder traversal - Step 1 ends


            if(prev != null && prev.val >= root.val) {
                if(first == null ) {
                    first = prev;
                }
                second = root;
            }
            prev = root;


            // General pattern of Iterative inorder traversal - Step 2
            root = root.right;
        }

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}
