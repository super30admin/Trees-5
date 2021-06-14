

//Time: O(n)
//Space: O(h) where h= height of tree
//Did it run successfully on leetcode: yes
class RecoverBinarySearchTree {
    //variable to keep track of previous and current nodes at the breaching point
    TreeNode first;
    TreeNode last;
    //variable to keep track of previous node to root during inorder traversal
    TreeNode prev;
    //flag to keep track of breach
    boolean flag;

    public void recoverTree(TreeNode root) {
        //if our tree is null
        if(root==null) return;
        //call helper function to set first and last nodes for first andlast breach respectively
        helper(root);
        //swap the nodes
        int tmp = first.val;
        first.val =last.val;
        last.val = tmp;
    }
    //method to set first and last node of both the breach
    public void helper(TreeNode root){

        //base
        //if root is null
        if(root==null) return;
        //logic
        //traverse left
        helper(root.left);
        //if previous exist and prev value is greater than root value
        if(prev!=null && prev.val>=root.val){
            //if it is the first breach
            if(!flag){
                //set flag to true to mark first breach
                flag = true;
                //update first and last
                first = prev;
                last = root;

            }//if second breach
            else{
                //update flag and last pointer
                flag = false;
                last = root;
            }
        }
        //update previous pointer
        prev = root;
        //if second breach already occur, do nothing
        if(!flag && first!=null && last!=null){}
        else{//move to righ child
            helper(root.right);
        }
    }
}