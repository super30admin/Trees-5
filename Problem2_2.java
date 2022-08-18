//Time Complexity: O(n)
//Space Complexity: O(h)
//Code run successfully on LeetCode.

public class Problem2_2 {

    public void recoverTree(TreeNode root){
        
        if(root == null)
            return;
        
        Stack<TreeNode> s = new Stack<>();
        
        TreeNode prev = null;
        TreeNode first = null;
        TreeNode second = null;
        
        while(!s.isEmpty() || root != null){
            
            while(root != null){
                s.push(root);
                root = root.left;
            }
            
            root = s.pop();
            
            if(prev != null && prev.val >= root.val){
                
                if(first == null)
                    first = prev;
                
                second = root;
            }
            
            prev = root;
            root = root.right;  
        }
        
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}
