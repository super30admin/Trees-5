// Time Complexity :O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yess
// Any problem you faced while coding this :NO


// Your code here along with comments explaining your approach: use pointers
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();

        TreeNode curr= root;

        while(curr!=null){
            if(curr.left==null){
                list.add(curr.val);
                curr=curr.right;
            }
            else{
                TreeNode pre=curr.left;
                while(pre.right!=null && pre.right!=curr){
                    pre=pre.right;
                }
                if(pre.right==null){
                    pre.right=curr;
                    curr=curr.left;
                }
                else {
                    pre.right = null; 
                    list.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return list;
    }
}