// Time Complexity : O(N)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
// HERE WE do in order traversal put the node reference in the list
// check where the breach is 1st and 2nd
// swap it

import java.util.*;

public class Solution {

    List<TreeNode> inorderNodes;

    public void recoverTree(TreeNode root) {

        inorderNodes = new ArrayList<>();

        inorder(root);

        TreeNode first = null;
        TreeNode second = null;

        for (int i = 0; i < inorderNodes.size() - 1; i++) {

            int currVal = inorderNodes.get(i).val;
            int nextVal = inorderNodes.get(i + 1).val;

            if (currVal > nextVal) {

                if (first == null) {
                    first = inorderNodes.get(i);
                    second = inorderNodes.get(i + 1);
                } else {
                    second = inorderNodes.get(i + 1);
                    break;
                }
            }
        }

        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }

    private void inorder(TreeNode node) {

        if (node == null) {
            return;
        }

        inorder(node.left);

        inorderNodes.add(node);

        inorder(node.right);
    }
}