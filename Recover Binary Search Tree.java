//Time complexity:O(n)
//SPace complexity:O(n)
class Solution {
    TreeNode first;
    TreeNode last;
     TreeNode prev;
    public void recoverTree(TreeNode root) {
        if(root==null) return;
        Stack<TreeNode> st=new Stack<>();
        
        while(root!=null || !st.isEmpty())
        {
            while(root!=null)
            {
                st.push(root);
                root=root.left;
            }
            root=st.pop();
         if(prev!=null && prev.val>=root.val)
        {
            if(first==null)
            {
                first=prev;
                last=root;
            }
            else
            {
                last=root;
            }
        }
            prev=root;
            root=root.right;
        }
        
        int temp=first.val;
        first.val=last.val;
        last.val=temp;
        
    }
}
