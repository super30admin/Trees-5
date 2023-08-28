// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/*
 * Keep a stack and push elements in an inorder traversal. If the element at the previous value is greater than current root, swap the elements. 
 */
 



class Problem2 {
    TreeNode prev; 
    TreeNode first; 
    TreeNode second;
    public void recoverTree(TreeNode root) {
        if(root == null)
            return;
        inorder(root);
        int temp = first.val;
        first.val = second.val; 
        second.val = temp;
    }
    private void inorder(TreeNode root){
        if(root == null)
            return; 
        Stack<TreeNode> st = new Stack<>();
        while(root != null || !st.isEmpty()){
            while(root != null){
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            if(prev != null && prev.val >= root.val){
                if(first == null){
                    first = prev; 
                    second = root;
                }
                else{
                    second = root;
                }
            }
            prev = root; 
            root = root.right;              
            }
        }
}
