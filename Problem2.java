public class Problem2 {
    //t.c-> O(n)
    //s.c-> O(h)
    public void recoverTree(TreeNode root) {
        if(root == null) {
            return;
        }

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
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}
