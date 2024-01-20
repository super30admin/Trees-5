// Time Complexity : O(n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {

        return morrisInorder(root);

        /*
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        TreeNode node = root;
        while(node!= null || !stack.isEmpty()){
            // traverse left
            while(node!= null){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            result.add(node.val);
            node = node.right;
        }
        return result;
        */
    }


    private List<Integer> morrisInorder(TreeNode root){
        List<Integer> result = new ArrayList<>();
        TreeNode current = root;
        while(current != null){
            TreeNode predessor = null;
            if(current.left != null){ // if current has aleft child
            predessor = current.left; // From left, we would want to go all the way to right
            while(predessor.right != null && predessor.right != current){
                predessor = predessor.right;
            }
            if(predessor.right == null){ // we found the predessor, so we will make a connection
            predessor.right = current;
            current= current.left;
            }
            else{
                // if the connection is already there
                predessor.right = null ; //removing connection
                result.add(current.val);
                current = current.right;
            }
            } else{
                result.add(current.val);
                current = current.right;
            }

        }
        return result;
    }


}