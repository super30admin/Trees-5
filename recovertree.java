class Solution {
    
    public void recoverTree(TreeNode root) {
        TreeNode first=null,second=null,prev=null;
        Stack<TreeNode> st = new Stack<>();
        while(root!=null || !st.isEmpty()){
            while(root!=null){
                st.push(root);
                root=root.left;
            }
            root=st.pop();
            if(prev!=null && prev.val>=root.val){
                if(first==null){
                    first=prev;
                    second=root;
                }
                else{
                    second=root;
                }
            }
            prev=root;
            root=root.right;
        }
        int temp=first.val;
        first.val=second.val;
        second.val=temp;
    }

}
