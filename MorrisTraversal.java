import java.util.ArrayList;
import java.util.List;

public class MorrisTraversal {
    public class TreeNode {
 int val;
 TreeNode left;
 TreeNode right;
 TreeNode() {}
 TreeNode(int val) { this.val = val; }
 TreeNode(int val, TreeNode left, TreeNode right) {
 this.val = val;
 this.left = left;
 this.right = right;
 }
 }
    /***
     * morris in order traversal.
     *
     * 1. take a current and set it to null.
     * 2. while current!=null{
     * if current.left ==null
     * list.add curremt
     * curr = curr.right
     * else{
     * find rightmost node of root.left
     * if rightmost.right == current
     * result.append current.val
     * move to curr.right
     * else{
     * rightmost.right = current
     *
     * }
     * }
     *
     * }
     *TIme complexity - o(3n) - o(n)
     * Space Complexity o(1)
     *
     */
    List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        // resut list
        List<Integer> result = new ArrayList<>();
        // set current to root.
        TreeNode current = root;

        // Move to the left
        while (current != null) {
            if (current.left == null) {
                result.add(current.val);
                current = current.right;
            } else {
                TreeNode rightmost = current.left;
                while (rightmost.right != null && rightmost.right != current) {
                    rightmost = rightmost.right;
                }
                if (rightmost.right == current) {
                    result.add(current.val);
                    rightmost.right = null;
                    current = current.right;
                } else if (rightmost.right == null) {
                    rightmost.right = current;
                    current = current.left;
                }
            }
        }
        return result;
    }
}
