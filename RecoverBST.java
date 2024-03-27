// TC: O(n)
// SC: O(1)

// Approach: Traverse the tree in inorder and mark the nodes which violate the property
// Swap them in the end

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

class RecoverBST {
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;

    public void recoverTree(TreeNode root) {
        dfs(root);
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);

        if (prev != null) {
            if (prev.val > root.val) {
                if (first == null) {
                    first = prev;
                    second = root;
                } else {
                    second = root;
                }
            }
        }

        prev = root;
        dfs(root.right);

    }
}