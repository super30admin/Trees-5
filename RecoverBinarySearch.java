//Approach - 1 : Inoder and Swap the nodes
//Time Complexity : O(n)
//Space Complexity : O(h)

class Solution {
    TreeNode prev;
    TreeNode first;
    TreeNode second;
    boolean flag;
    //TreeNode curr // root only
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        inorder(root);
        
        //swap the values
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    private void inorder(TreeNode root){
        //base
        if(root == null) return;
         
        //logic
        inorder(root.left);
        
        //breach happens
        if(prev != null && prev.val > root.val){
            //first breach
            if(!flag){ 
                flag = true;
                first = prev;
                second = root;
            }
            else{ // second breach
                second = root;
            }
        }
        
        prev = root;
        inorder(root.right);
  
    }
}


//Approach - 2 : Iterative by using Stack, Inoder and Swap the nodes
//Time Complexity : O(n)
//Space Complexity : O(h)

class Solution {
    TreeNode prev;
    TreeNode first;
    TreeNode second;
    boolean flag;
    //TreeNode curr // root only
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        inorder(root);
        
        //swap the values
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    private void inorder(TreeNode root){

        Stack<TreeNode> st = new Stack<>();
        while(!st.isEmpty() || root != null){
            while(root != null){
                st.push(root);
                root = root.left;
            }
        root = st.pop(); 
        
        //breach happens
        if(prev != null && prev.val > root.val){
            //first breach
            if(!flag){ 
                flag = true;
                first = prev;
                second = root;
            }
            else{ // second breach
                second = root;
            }
        }        
        prev = root;
        root = root.right;
        }
    }
}
