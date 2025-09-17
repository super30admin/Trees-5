//TC: O(n) — each node is pushed/popped at most once and visited once.
//SC: O(h) — stack holds at most the height of the tree (h); worst-case O(n) for a skewed tree.

//Use a stack; from curr, push the entire left chain down to null.
//Pop the top, record its value (inorder “visit”).
//Move to its right child and repeat until curr == null and stack is empty.

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> st = new ArrayDeque<>();
        TreeNode curr = root;

        while (curr != null || !st.isEmpty()) {
            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            ans.add(curr.val);
            curr = curr.right;
        }
        return ans;
    }
}