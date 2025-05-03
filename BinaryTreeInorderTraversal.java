import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 //TC: O(n)
 //SC: O(1)
class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode curr=root;
        TreeNode prev=null;
        List<Integer> res=new ArrayList<>();
        while(curr!=null){
            if(curr.left!=null){
                prev=curr.left;
                while(prev.right!=null && prev.right!=curr){
                    prev=prev.right;
                }
                if(prev.right==curr){
                    prev.right=null;
                    res.add(curr.val);
                    curr=curr.right;
                }else{
                    prev.right=curr;
                    curr=curr.left;
                }
            }else{
                res.add(curr.val);
                curr=curr.right;
            }

        }
        return res;
    }
}