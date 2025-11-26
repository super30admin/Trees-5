// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
this is a special way to traversing a tree without actually using stack space
the idea is to traverse the left side and the do got left right most node and connect it to the parent
                        100
                    90          ....
                80      95         .....
                    94      99
    so connect 99 with 100 we first go left of 100 to 90
    then move right will we hit null at that point prev will be at 99 and its left right are null so we connect its right to 100 so when we come up
    the tree we can use that to move up levels while going up we will remove the pointer as well so have the tree back

*/

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode pre = cur.left; // moving down using left
                while (pre.right != null && pre.right != cur) { // while moving down we check till pre.right is not null
                                                                // and while moving up we check pre.right = cur
                    pre = pre.right;
                }
                if (pre.right == null) { // connecting the tree node to cur while moving down
                    pre.right = cur;
                    cur = cur.left;
                } else { // removing the connection while going up
                    pre.right = null;
                    result.add(cur.val);
                    cur = cur.right;
                }
            } else {
                result.add(cur.val);
                cur = cur.right;
            }
        }
        return result;
    }
}