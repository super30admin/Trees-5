// approch 1 
// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// approch 2
// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
import java.util.*;

// TreeNode
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

class Main {
    private TreeNode first;
    private TreeNode second;
    private TreeNode prev;

    // approch 1 using inorder traversal recursive approch
    public void recoverTree1(TreeNode root) {
        if (root == null)
            return;
        dfs(root);
        // swap the values after we found breach nodes
        int temp = first.val;
        first.val = second.val;
        second.val = temp;

    }

    private void dfs(TreeNode root) {
        // base
        if (root == null)
            return;

        // main logic
        // explore left node in tree
        dfs(root.left);
        // inorder condition check
        if (prev != null && prev.val >= root.val) {
            // here we check if first breach is already there or not
            // if not for first breach we make first = prev
            // and second = root
            // if it is second breach we only change second node
            if (first == null) {
                first = prev;
                second = root;
            } else {
                second = root;
            }
        }
        // after condtion check update prev to current node
        prev = root;
        // explore right node in tree
        dfs(root.right);
    }

    // approch 2 using inorder traversal iterative approch
    public void recoverTree2(TreeNode root) {
        if (root == null)
            return;

        TreeNode first = null;
        TreeNode second = null;
        TreeNode prev = null;
        // stack for iterative inorder
        Stack<TreeNode> st = new Stack<>();
        // while loop for iterative traversal
        while (root != null || !st.isEmpty()) {
            // while root null iteratively push this node into the stack
            while (root != null) {
                st.push(root);
                root = root.left;
            }
            // pop the first element from the stack and make it root beacuse we want to go
            // to right side of the root F
            root = st.pop();
            // inorder logic
            if (prev != null && prev.val >= root.val) {
                // here we check if first breach is already there or not
                // if not for first breach we make first = prev
                // and second = root
                // if it is second breach we only change second node
                if (first == null) {
                    first = prev;
                    second = root;
                } else {
                    second = root;
                }
            }
            prev = root;
            // make root = root.right;
            root = root.right;
        }

        // swap the values after we found breach nodes
        int temp = first.val;
        first.val = second.val;
        second.val = temp;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        Main m = new Main();
        m.recoverTree1(root);
        m.recoverTree2(root);

    }
}