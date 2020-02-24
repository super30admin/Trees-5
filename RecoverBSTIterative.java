//TC : O(n) where n is number of nodes in tree
//SC : O(h) h is height of stack
class Solution {
    TreeNode first,last,middle,prev;
    public void recoverTree(TreeNode root) {
        
        if(root == null) return;
        
        inorder(root);
        
        int temp;
      //  System.out.println(first.val+" "+middle.val);
        if(first!=null && last!=null){
            
            temp = first.val;
            first.val = last.val;
            last.val = temp;
            
        }
        else if(first!=null && middle!=null) {
            
            temp = first.val;
            first.val = middle.val;
            middle.val = temp;
            
        }
        
    }
    
    private void inorder(TreeNode root){
        
        if(root == null) return;
        
        Stack<TreeNode> st = new Stack<>();
        
        while(root!=null || !st.isEmpty()){
            while(root!=null){
                st.push(root);
                root = root.left;
            }
             root = st.pop();
            
              
        if(prev!= null && prev.val > root.val){
            
            if(first==null){
                first = prev;
                middle = root;
            }
            else{
                last = root;
            }   
        }
            
       prev = root;
            
        root = root.right;    
            
       
                
        }
      
        
     
    }
}