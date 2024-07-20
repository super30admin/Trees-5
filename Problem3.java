/*
    LC - 94. Binary Tree Inorder Traversal
    TC - O(n)
    SC - O(h)
    Approach -
        Basic Inorder traversal (left, root, right)
        Using stack & iterative approach and add the elements in the list
*/

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        Stack<TreeNode> st = new Stack<>();
        List<Integer> result = new ArrayList<>();
        while(!st.isEmpty() || root!=null) {
            while(root!=null) {
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }
}

/*
    LC - 94. Binary Tree Inorder Traversal
    TC - O(n)
    SC - O(h)
    Approach -
        Basic Inorder traversal (left, root, right)
        do the recursive call and add the elements in the list
*/

class Solution {
    List<Integer> result;
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        dfs(root);
        return result;
    }
    public void dfs(TreeNode root) {
        if(root == null){
            return;
        }
        dfs(root.left);
        result.add(root.val);
        dfs(root.right);
    }
}