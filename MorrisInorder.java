/*Morris inorder -> use right pointer to point to parent */
//O(n * h).  Amortized  O(n)
class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode prev;

        while (root != null) {
            if (root.left == null) {
                result.add(root.val);
                root = root.right;
            }else{
                prev = root.left;
                while (prev.right !=null && prev.right!= root) {
                    prev = prev.right;
                }
                if(prev.right == null){
                    prev.right = root;
                root = root.left;
                }else{
                    prev.right = null;
                    result.add(root.val);
                root = root.right;
                }
                
            }

        }
        return result;
    }

}