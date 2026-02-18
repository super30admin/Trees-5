import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
// Time: O(n)
// Space: O(h) - for values in stack
// inorder traversal using stack
public class MorrisInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }

    // Time: O(n)
    // Space: O(1)
    // inorder traversal keeping current node and its predecessor in variables
    // we need to store root's predecessor in the left subtree, so that we can traverse back from child to root.
    // To keep this predecessor, we will traverse the rightmost child on the left subtree and make child.right = parent
    // Once we are done traversing, we can go from right child to the parent and continue.
    public List<Integer> morrisInorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode current = root;
        while (current != null){
            // if no left child, visit this and move to right
            if(current.left == null){
                result.add(current.val);
                current =current.right;
            }else {
                // if left child, find the predecessor by keep exploring right
                TreeNode pred = current.left;
                while(pred.right != current && pred.right != null){
                    pred = pred.right;
                }
                // if predecessor is not pointing to parent, make it point to parent.
                if(pred.right == null){
                    pred.right = current;
                    // Move current to next left subtree
                    current = current.left;
                }else {
                    // if predecessor is pointing to parent, remove the connection and explore nodes on right
                    pred.right = null;
                    result.add(current.val);
                    current = current.right;
                }
            }
        }
        return result;
    }
}
