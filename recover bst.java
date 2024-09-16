//Timecomplexity:- O(n);
//Space complexity:- O(N);
//Did it run on leetcode:- Yes.
//Your code with approach :- reccursively travelling in inorder when prev val>root.val ,storing prev in x and root in y .
//After reccursion changing x and y values.
class Solution {                                                          
    TreeNode prev;
    TreeNode x;
    TreeNode y;
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp=x.val;
        x.val=y.val;
        y.val=temp;
        
    }
    private void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        if(prev!=null){
            if(prev.val>root.val){
                if(x==null){
                    x=prev;
                }
                 y=root;
            }
           
        }
        prev=root;
        inorder(root.right);
    }
}

