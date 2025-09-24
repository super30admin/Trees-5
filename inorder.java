class Solution{
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> in=new ArrayList<>();
        Stack<TreeNode> s=new Stack<>();
        TreeNode curr=root;
        while (curr != null || !s.isEmpty()){
        while(curr!=null){
            s.push(curr);
            curr=curr.left;
        }
        curr=s.pop();
        in.add(curr.val);
        curr=curr.right;
        }
        return in;
    }
}