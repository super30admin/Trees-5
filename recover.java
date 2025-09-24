class Solution {
    TreeNode prev,first,second;
    public void recoverTree(TreeNode root) {
        
        Stack<TreeNode>st=new Stack<>();
        while(!st.isEmpty() || root!=null){
            while(root!=null){
                st.push(root);
                root=root.left;
            }
            root=st.pop();
            if(prev!=null && prev.val>root.val){
                if(first==null)
                {
                    first=prev;
                }
                second=root;
            }
        
        prev=root;
        root=root.right;

        }
        int temp=first.val;
        first.val=second.val;
        second.val=temp;

    }
}