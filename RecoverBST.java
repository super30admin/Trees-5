import java.util.Stack;
//Time Complexity : O(n)
//Space Complexity : O(H); were H is height of the tree
public class RecoverBST {		
	/**Definition for binary tree node.**/
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) {this.val = val;}
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	/**Approach1: Recursive**/
	TreeNode first;
    TreeNode second;   
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        inorder(root);
        //swap the mismatched nodes
        int temp= first.val;
        first.val=second.val;
        second.val=temp;
        System.out.println(first.val +" , "+ second.val);
    }
    private void inorder(TreeNode root){
        //base
        if(root == null) return;        
        //logic        
        inorder(root.left);        
        if(prev!=null && root.val < prev.val){
        	//breach
            if(first==null){
                first= prev;
                second= root;
            }else{
                second= root;
            }
        }
        prev=root;
        inorder(root.right);
    }
    
    /**Approach2: Iterative**/
    /*public void recoverTree(TreeNode root) {
        TreeNode first=null;
        TreeNode second=null;   
        TreeNode prev=null;
        
        //Iterative
        Stack<TreeNode> st= new Stack<>();       
        while(root!=null || !st.isEmpty()){
            while(root!=null){
                st.push(root);
                root= root.left;
            }
            root=st.pop();
            if(prev!=null && root.val < prev.val){
                //breach
                if(first==null){
                    first=prev;
                    second=root;
                }else{
                    second=root;
                }
            }            
            prev=root;
            root=root.right;
        }          
        //swap the mismatched nodes
        int temp= first.val;
        first.val=second.val;
        second.val=temp;
        
        System.out.println(first.val +" , "+ second.val);
    }*/
	
	// Driver code to test above
	public static void main (String[] args) {
		RecoverBST ob= new RecoverBST();
		TreeNode t1= new TreeNode(10, 
				new TreeNode(5, new TreeNode(3, new TreeNode(1), new TreeNode(4)), new TreeNode(7, new TreeNode(6), new TreeNode(15))), 
				new TreeNode(20, new TreeNode(8, new TreeNode(12), new TreeNode(18)), new TreeNode(30, new TreeNode(25), new TreeNode(40))));
		
		System.out.println("Mismatched nodes are: ");
		ob.recoverTree(t1);		
	}	
}
