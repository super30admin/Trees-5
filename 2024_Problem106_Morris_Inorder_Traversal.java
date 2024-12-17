//94. BT Inorder Traversal - https://leetcode.com/problems/binary-tree-inorder-traversal/description/
//Time Complexity: O(n)
//Space Complexity: 0(h)

//Recurrsion:
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private void inorder(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        inorder(node.left, result);
        result.add(node.val);
        inorder(node.right, result);
    }
}


//Iterative:
//Time Complexity: O(n)
//Space Complexity: 0(h)
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left; //Process left
            }
            root = stack.pop();
            result.add(root.val); //process root
            root = root.right; //process right
        }
        return result;
    }
}