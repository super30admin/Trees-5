# Time complexity:O(n)
# Space complexity: 0(1)
# Did code run successfully on leetcode: yes
# Any problem you faced: No


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    TreeNode firstNode, secondNode, previousNode;

    public void recoverTree(TreeNode root) {

        firstNode = null;
        secondNode = null;
        previousNode = new TreeNode(Integer.MIN_VALUE);

        TreeNode cursor = root;
        Stack<TreeNode> stack = new Stack();

        while(cursor != null){
            stack.push(cursor);
            cursor = cursor.left;
        }

        while(!stack.isEmpty()){
            cursor = stack.pop();
            if(firstNode == null && previousNode.val > cursor.val){
            firstNode = previousNode;
        }

         if(firstNode != null && previousNode.val > cursor.val){
            secondNode = cursor;
        }
        previousNode = cursor;

        if(cursor.right != null){
            cursor = cursor.right;
            while(cursor!=null){
                stack.push(cursor);
                cursor = cursor.left;
                }
            }
        }

        swap(firstNode, secondNode);

    }

    private void swap(TreeNode a, TreeNode b){
        int val = a.val;
        a.val = b.val;
        b.val = val;
    }


}