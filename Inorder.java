/*
 * tc - o(n) sc - o(1)
 */
public class Inorder {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode curr = root;
        while(curr != null){
            if(curr.left == null){
                result.add(curr.val);
                curr = curr.right;
            }else{
                TreeNode pre = curr.left;
                while(pre.right != null && pre.right != curr){
                    pre = pre.right;
                }
                if(pre.right == null){
                    //made connection
                    pre.right = curr;
                    curr = curr.left;
                }else{
                    //remove connection
                    pre.right = null;
                    result.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return result;
    }
}
