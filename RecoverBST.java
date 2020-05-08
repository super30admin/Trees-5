//Time Complexity: O(n)
//Space Complexity: O(max_depth)
import java.util.*;

class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode first = null;
        TreeNode second = null;
        TreeNode buffer = null;
        TreeNode prev = null;
        while(root!=null || !st.isEmpty()){
            while(root!=null){
            st.push(root);
            root=root.left;
            }
            root=st.pop();
            if(prev!=null && prev.val>=root.val){
                if(first==null){
                    first = prev;
                    buffer = root;
                }
                else{
                    second = root;
                }                
            }
            prev=root;
            root=root.right;
        }
        
        if(second==null)
            swap(first, buffer);
        else
            swap(first, second);
    }
    public void swap(TreeNode t1, TreeNode t2){
        int temp = t1.val;
        t1.val = t2.val;
        t2.val = temp;
    }
}