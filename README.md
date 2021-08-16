# Trees-5

## Problem1 Populating Next Right Pointers in Each Node(https://leetcode.com/problems/populating-next-right-pointers-in-each-node/)

You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the
following definition:

struct Node {

int val;

Node \*left;

Node \*right;

Node \*next;

}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Example:

Input: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":{"$id":"6","left":null,"next":null,"right":null,"val":6},"next":null,"right":{"$id":"7","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}

Output: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":{"$id":"5","left":null,"next":{"$id":"6","left":null,"next":null,"right":null,"val":7},"right":null,"val":6},"right":null,"val":5},"right":null,"val":4},"next":{"$id":"7","left":{"$ref":"5"},"next":null,"right":{"$ref":"6"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"7"},"val":1}

Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right
node, just like in Figure B.

Note:

You may only use constant extra space.

Recursive approach is fine, implicit stack space does not count as extra space for this problem.

//Time Complexity = O(N)
//Space Complexity = O(H)

/\*
// Definition for a Node.
class Node {
public int val;
public Node left;
public Node right;
public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

};
\*/

class Solution {
public Node connect(Node root) {
if(root == null) {
return root;
}
Node level = root;

        while(level.left != null) {
            Node current = level;

            while(current != null) {
                current.left.next = current.right;

                if(current.next != null) {
                    current.right.next = current.next.left;
                }
                current = current.next;
            }
            level = level.left;
        }
        return root;
    }

}

//Time Complexity = O(N)
//Space Complexity = O(H)

## Problem2 Recover Binary Search Tree(https://leetcode.com/problems/recover-binary-search-tree/)

Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Example 1:

Input: [1,3,null,null,2]

        1

      /

    3

      \

        2

Output: [3,1,null,null,2]

        3

      /

    1

      \

        2

Example 2:

Input: [3,1,4,null,null,2]

          3

        / \

      1   4

        /

      2

Output: [2,1,4,null,null,3]

        2

      / \

    1   4

       /

     3


     /**

- Definition for a binary tree node.
- public class TreeNode {
-     int val;
-     TreeNode left;
-     TreeNode right;
-     TreeNode() {}
-     TreeNode(int val) { this.val = val; }
-     TreeNode(int val, TreeNode left, TreeNode right) {
-         this.val = val;
-         this.left = left;
-         this.right = right;
-     }
- }
  \*/

class Solution {
boolean flag;
TreeNode prev;
TreeNode first, last;
public void recoverTree(TreeNode root) {
if(root == null) {
return;
}
inorder(root);
int temp = first.val;
first.val = last.val;
last.val = temp;

    }
    private void inorder(TreeNode root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        if(prev != null && prev.val > root.val) {
            if(flag != true) {
                first = prev;
                last = root;
                flag = true;
            } else {
                last = root;
            }
        }
        prev = root;
        inorder(root.right);
    }

}
