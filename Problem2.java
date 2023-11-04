
//TimeComplexity - O(N)
//SpaceComplexity -O(H)
// Passed all Test cases on Leetcode : Yes
// Any issues faced while executing the code : No

import java.util.Stack;

public class Problem2 {

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
    public void recoverTree(TreeNode root) {

        TreeNode first = null;
        TreeNode second = null;
        TreeNode prev = null;
        Stack<TreeNode> s = new Stack<>();

        while(root != null || !s.isEmpty()){
            while(root != null){
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            if(prev != null && prev.val > root.val){
                if(first== null){
                    first = prev;
                }
                second = root;
            }

            prev = root;
            root= root.right;
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;

    }
}
