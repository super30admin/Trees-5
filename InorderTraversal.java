public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        // return inorderTraversalIterative(root);
        // return inorderTraversalRecursive(root);
        return morrisInorderTraversal(root);
    }

    // TC: O(N) where N is number of nodes in tree
    // SC: O(1)
    private List<Integer> morrisInorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                res.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode predecessor = curr.left;
                while (predecessor.right != null && predecessor.right != curr) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    predecessor.right = curr;
                    curr = curr.left;
                } else {
                    predecessor.right = null;
                    res.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return res;
    }

    // TC: O(N) where N is number of nodes in tree
    // SC: O(H) where H is height of tree
    private List<Integer> inorderTraversalRecursive(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    private void inorder(TreeNode root, List<Integer> res) {
        if (root != null) {
            inorder(root.left, res);
            res.add(root.val);
            inorder(root.right, res);
        }
    }
    
    // TC: O(N) where N is number of nodes in tree
    // SC: O(H) where H is height of tree
    private List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode curr = stack.pop();
            res.add(curr.val);
            root = curr.right;
        }
        return res;
    }
}
