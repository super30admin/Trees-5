class Solution {
 
     TreeNode x = null, y = null, pred = null;
    public void recoverTree(TreeNode root) {
        helper( root);  
        swap(x, y);
    }
    
    public void helper(TreeNode node){
        if(node == null) return;
        System.out.println("Starting:"+node.val);
        helper(node.left);
          System.out.println("Middle:"+node.val);
        if(pred!= null &&  node.val< pred.val) {
            y= node;
            if(x== null) x= pred;
            else return;
        }
         pred= node;   
        
        helper(node.right);
          System.out.println("end:"+node.val);
    }
    
    public void swap(TreeNode a, TreeNode b){
        int temp= a.val;
        a.val =b.val;
        b.val= temp;
    }
}

//Time - O(n)
//space- O(n)