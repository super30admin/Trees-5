// Time Complexity : The time complexity is O(n) where n is the number of tree nodes
// Space Complexity : The space complexity if O(n) where n is the number of tree nodes
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    List<TreeNode> treeList;

    public void recoverTree(TreeNode root) {

        treeList = new ArrayList<>();

        treeList.add(new TreeNode(Integer.MIN_VALUE));
        dfs(root);
        treeList.add(new TreeNode(Integer.MAX_VALUE));

        TreeNode first = null;
        int firstIndex=0;

        Stack<TreeNode> s = new Stack<>();
        Stack<Integer> idx = new Stack<>();

        for(int i=1;i<treeList.size()-1;i++){

            TreeNode cur = treeList.get(i);

            // Find nodes that are against the BST
            if(cur.val < treeList.get(i-1).val || cur.val > treeList.get(i+1).val){
                if(first == null){
                    first = cur;
                    firstIndex = i;
                }
                else{
                    s.push(cur);
                    idx.push(i);
                }
                System.out.println(cur.val);
            }
        }

        if(s.size() == 1){
            TreeNode cur = s.pop();
            int temp = first.val;
            first.val = cur.val;
            cur.val = temp;
            return;
        }

        // Swap the nodes
        while(!s.isEmpty()){

            TreeNode cur = s.pop();
            int index = idx.pop();

            int secondPrev = treeList.get(index-1).val;
            int secondNext = treeList.get(index+1).val;

            int firstPrev = treeList.get(firstIndex-1).val;
            int firstNext = treeList.get(firstIndex+1).val;

            if(first.val > secondPrev && first.val < secondNext && cur.val > firstPrev && cur.val < firstNext){
                int temp = first.val;
                first.val = cur.val;
                cur.val = temp;
                return;
            }

        }

    }

    public void dfs(TreeNode root){

        if(root == null){
            return;
        }

        dfs(root.left);
        treeList.add(root);
        dfs(root.right);

    }
}