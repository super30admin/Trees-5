//TC=O(n)
//SC=(h)
class Problem99 {
    TreeNode first;
    TreeNode second;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp=first.val;
        first.val=second.val;
        second.val=temp;
    }
    
    public void inorder(TreeNode root){
        Stack<TreeNode> stk=new Stack<>();
        //base condition
        if(root==null)
            return;
       while(!stk.isEmpty() || root!=null){
           while(root!=null){
               stk.push(root);
               root=root.left;
           }
           root=stk.pop();
           //detect the breach
           if(prev!=null && prev.val>root.val){
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
    }
}
