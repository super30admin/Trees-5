public class RecoverBS {
    //https://leetcode.com/problems/recover-binary-search-tree/description/
    /*
    *
    *
    * TC - O(n)
    * SC - O(h)
    * */

    //Recursive Approach

    TreeNode prev, first, second;
    int count;
    public void recoverTree(TreeNode root) {
        if(root==null) return;
        dfs(root);
        int temp = first.val;
        first.val=second.val;
        second.val=temp;

    }
    private void dfs(TreeNode root){
        if(root == null) return;
        if(count<2) dfs(root.left);
        if(prev!=null && prev.val>root.val){
            count++;
            if(first == null) first = prev;
            second = root;
        }
        prev = root;
        if(count<2) dfs(root.right);


    }
    //Iterative Approach
    /*
      TreeNode prev, first, second;
int count;
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> st = new Stack<>();
        while(root!=null || (!st.isEmpty())){
            while(root!=null){
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            if(prev!=null && prev.val>root.val){
                count++;
                if(first==null) first = prev;
                second = root;
            }
            if(count ==2) break;
            prev =root;
            root = root.right;
        }
        int temp = 0;
        temp= first.val;
        first.val = second.val;
        second.val = temp;

    }
    * */

}
