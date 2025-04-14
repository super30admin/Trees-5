//LC:16Recover Binary Search Tree(https://leetcode.com/problems/recover-binary-search-tree/)

import java.util.Stack;

public class RecoverBinarySearchTree {

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

  // Iterative method
    /*
    Time Complexity = o(n)
    Space complexity =o(h)
    // perform inorder traversal. ( property of binary search tree when inorder
    traversal is performed, elements output in ascending order
    first until left is not null or stack is not  empty,
    check if root not null and push elements to stack buy going left.
    once root is null,
    pop the stack and set the value to root.

   - take two pointers, prev and root. initially prev = null
    if prev is not null and if prev values is grater than root,
     set variable first = the previpus value.
     set variable secind = the root value.
     continue prev = root.
     root = root.right



     */

    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode prev = null;
        TreeNode first = null, second = null;
        Stack<TreeNode> s = new Stack<>();
        while(root!=null || !s.isEmpty()){
            while(root!=null){
                s.push(root);
                root=root.left;
            }
            root = s.pop();
            if(prev!=null && prev.val>root.val){
                if(first==null){
                    first=prev;
                }
                second = root;
            }
            prev=root;
            root=root.right;
        }
        int temp = first.val;
        first.val=second.val;
        second.val=temp;

    }
}
