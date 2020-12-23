package trees;

public class RecoverBST_solution {
	
	// step 1 get inorder representation O(n)
	// step 2 get the value to be swapped O(n)
	// do inorder and swap the values O(n)
//	spc-O(n)
	 
    public void inorder(TreeNode root, List<Integer> nums){
        if(root==null) return ;
        
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
        
    }
    
    public int[] itemstobeswapped(List<Integer> nums){
        int n = nums.size();
        int x = -1, y = -1;
        for(int i=0;i<n-1;i++){
            if(nums.get(i+1)<nums.get(i)){
                
                y=nums.get(i+1);
                
                
                
                if(x==-1) x=nums.get(i);
                
                else break;
                
                
            }
        }
        
        
        return new int [] {x,y};
        
    }
    
    
    public void recover(TreeNode r, int count, int x, int y){
        if(r!=null){
            if(r.val==x|| r.val==y){
                
                r.val=r.val==x?y:x;
                count--;
                if (count==0) return;
            }
            
            
            
            
        recover(r.left, count, x,y);
        recover(r.right, count, x,y);
        }
        

        
        
    }
    
    
    public void recoverTree(TreeNode root) {
        List<Integer> nums = new ArrayList();
        
        inorder(root, nums);
        
        int [] swapped=itemstobeswapped(nums);
        
        recover(root, 2, swapped[0], swapped[1]);
    }
    
    
    // approach 2
    

    // O(h) -space , h-heigth of tree.
    // O(n) -time.
        
    TreeNode first;
    TreeNode prev;
    TreeNode last;
    
    public void inorder(TreeNode root){
        if (root==null) return ;
        
        inorder(root.left);
        
        
        if(prev!=null && prev.val>=root.val ){
            
            if(first==null){
                first=prev;
                last=root;
            }
            else{
                last=root;
            }
            
            
        }
        
        prev=root;
        
        inorder(root.right);
        
        
    }
    
    
    public void recoverTree(TreeNode root) {
        if (root==null) return;
        inorder(root);
        
        int temp=first.val;
        first.val=last.val;
        last.val=temp;
    }
    
    
    
}
