
import java.util.ArrayList;
import java.util.List;
//Time Complexity: O(n)
// Space Complexity: O(n)
public class problem3 {


    class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result= new ArrayList<>();
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left == null) {  // if no left, visit the node
                result.add(curr.val);
                curr = curr.right;
            }
            else {
                // find predcessor
                TreeNode pred= curr.left;
                while(pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }
                if (pred.right == null) {
                    // establish thread
                    pred.right = curr;
                    curr = curr.left;
                }

                else {
                    //remove thread and visit the node
                    pred.right = null;
                    result.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return result;
    }

}
