//Time Complexity: O(n) where number of nodes in BST
//Space Complexity: O(h) where h is height of tree in recursive solution and in iterative approach its size of stack
//Did it run successfully on LeetCode: yes

package com.madhurima;

import java.util.Stack;

// Definition for a binary tree node.
class TreeNode {
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



public class RecoverBinarySearchTree {

}

class SolutionRecursiveSolution {

    TreeNode prev, first, second;

    //recursive in order traversal
    public void recoverTree(TreeNode root) {

        if(root == null) return;

        dfs(root);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;

    }

    private void dfs(TreeNode root){
        //base
        if(root == null){
            return;
        }

        //logic
        dfs(root.left);

        if(prev != null && prev.val > root.val){
            if(first == null){
                first = prev;
            }
            second = root;
        }

        prev = root;

        dfs(root.right);
    }


    //iterative solution using stack
    class Solution {

        TreeNode prev, first, second;
        int cnt = 0;

        //iterative approach using stack
        public void recoverTree(TreeNode root) {
            if(root == null){
                return;
            }

            Stack<TreeNode> s = new Stack<>();
            // int cnt = 0;

            while(root != null || !s.isEmpty()){
                while(root != null){
                    s.push(root);
                    root = root.left;
                }

                root = s.pop();

                if(prev != null && prev.val > root.val){
                    cnt++;
                    if(first == null){
                        first = prev;
                    }
                    second = root;
                }

                if(cnt > 2){
                    break;
                }

                prev = root;

                root = root.right;

            }

            int temp = first.val;
            first.val = second.val;
            second.val = temp;

        }
    }





}





