/*
Time Complexity: O(n) - We perform an in-order traversal of the tree, visiting each node once.
Space Complexity: O(h) - Where h is the height of the tree, due to the recursive stack or explicit stack usage.
*/

class Solution {
    public void recoverTree(TreeNode root) {
        //base
        if(root == null) {
            return;
        }

        //logic
        TreeNode prev, first, second;
        prev = first = second = null;
        int count = 0;
        Stack<TreeNode> s = new Stack<>();

        while(root != null || !s.isEmpty()) {
            while(root != null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            if(prev != null && prev.val > root.val) {
                count++;
                if(first == null) {
                    first = prev;
                }
                second = root;
            }
            prev = root;
            root = root.right;

            if(count == 2) {
                break;
            }
        }

        //swap
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}