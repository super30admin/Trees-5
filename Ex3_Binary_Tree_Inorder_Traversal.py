# ----------------------------------------------------
# Intuition:
#
# Perform an inorder traversal of a binary tree:
#    Left → Node → Right
#
# 1.   Most Optimal – Morris Traversal (O(1) space):
#    - Uses threaded binary tree idea to simulate the stack.
#    - If left child exists, find its predecessor (rightmost node).
#      → Link predecessor’s right to current node.
#    - Otherwise, visit the node and go right.
#    - Break the thread when visited back.
#    → Time: O(n), Space: O(1)
#
# 2.   Iterative Using Stack:
#    - Use stack to simulate recursion.
#    → Time: O(n), Space: O(h) (h = height of tree)
#
# 3.   Recursive:
#    - Simple DFS recursion.
#    → Time: O(n), Space: O(h) for call stack
# ----------------------------------------------------

from typing import Optional, List

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:

        # ----------------------------------------------------
        # Morris Traversal (O(1) Space)
        # ----------------------------------------------------
        res = []
        curr = root

        while curr:
            if not curr.left:
                res.append(curr.val)
                curr = curr.right
            else:
                pre = curr.left
                while pre.right and pre.right != curr:
                    pre = pre.right

                if not pre.right:
                    pre.right = curr
                    curr = curr.left
                else:
                    pre.right = None
                    res.append(curr.val)
                    curr = curr.right

        return res

        # ----------------------------------------------------
        #  Iterative Using Stack
        # ----------------------------------------------------
        # res = []
        # stack = []
        # curr = root
        # while curr or stack:
        #     while curr:
        #         stack.append(curr)
        #         curr = curr.left
        #     curr = stack.pop()
        #     res.append(curr.val)
        #     curr = curr.right
        # return res

        # ----------------------------------------------------
        #  Recursive
        # ----------------------------------------------------
        # res = []
        # def inorder(node):
        #     if not node:
        #         return
        #     inorder(node.left)
        #     res.append(node.val)
        #     inorder(node.right)
        # inorder(root)
        # return res
