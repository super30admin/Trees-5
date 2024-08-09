//Leetcode : 99. Recover Binary Search Tree 

//Iterative solution
//Time Complexity: O(n) , n is total no of nodes in the tree
//Space Complexity: O(n) , Size of the stack which is equal to the height of the tree
class Solution {
    public void recoverTree(TreeNode root) {
       if(root== null) return;
        TreeNode pre= null;
        TreeNode n1=null;
        TreeNode n2=null;
        Stack<TreeNode> s = new Stack<>();
        while(!s.isEmpty()  || root!=null){
            while(root!=null){
                s.push(root);
                root= root.left;
            }
            root= s.pop();
            if(pre!=null && root.val<pre.val){
                n1= root;
                if (n2==null){
                    n2=pre;
                }
                else break;
            }
            pre=root;
            root = root.right;
        }
        if(n1!=null && n2!=null){
              int temp = n1.val;
              n1.val= n2.val;
              n2.val= temp;
        }
      
        
    }
}

-------------------------------------------------------------
//recursive approach
//Time Complexity: O(n) , n is total no of nodes in the tree
//Space Complexity: O(n) , Size of the stack which is equal to the height of the tree

class Solution {
        TreeNode pre= null;
        TreeNode n1=null;
        TreeNode n2=null;
    public void recoverTree(TreeNode root) {
       // if(root== null) return;
         dfs(root);
         int temp = n1.val;
         n1.val= n2.val;
         n2.val= temp;
     }
    public void dfs(TreeNode root){
        if(root==null) return;
        dfs(root.left);
        if(pre!=null && root.val<pre.val){
                n1= root;
                if (n2==null){
                    n2=pre;
                }
                else return;
            }
            pre=root;
        dfs(root.right);
    }
}