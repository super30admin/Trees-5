//Recover a binary tree
//time o(n)
//space o(1)
//iterative solution
class Solution {
    boolean flag;
    TreeNode prev, first, mid, last;
    public void recoverTree(TreeNode root) {
        if(root == null)
            return;
        inorder(root);
        int temp;
        if(first != null && last != null) {
            temp = first.val;
            first.val = last.val;
            last.val = temp;
        }
        else if(first != null) {
            temp = mid.val;
            mid.val = first.val;
            first.val = temp;
        }
    }
    
    private void inorder(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        
        while(root!=null || !st.isEmpty()) {
            while(root != null) {
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            if(prev != null && root.val < prev.val) {
                if(!flag) {
                    flag = true;
                    first = prev;
                    mid = root;
                }
                else {
                    last = root;
                }
            }
            prev = root;
            root = root.right;
        }
    }
}

//Recursion
//time o(n)
//space o(1)
class Solution {
    boolean flag;
    TreeNode prev, first, mid, last;
    public void recoverTree(TreeNode root) {
        if(root == null)
            return;
        inorder(root);
        int temp;
        if(first != null && last != null) {
            temp = first.val;
            first.val = last.val;
            last.val = temp;
        }
        else if(first != null) {
            temp = mid.val;
            mid.val = first.val;
            first.val = temp;
        }
    }
    
    private void inorder(TreeNode root) {
        //base case
        if(root == null)
            return;
        //logic
        inorder(root.left);
        if(prev != null && root.val < prev.val) {
            if(!flag) {
                flag = true;
                first = prev;
                mid = root;
            }
            else {
                    last = root;
                }
            }
            prev = root;
        inorder(root.right);
    }
}