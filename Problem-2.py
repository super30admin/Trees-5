# Time Complexity : O(n), n = number of nodes
# Space Complexity : O(h), h = height of tree (recursion stack)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# 1. Use in-order traversal to detect the two swapped nodes in BST.
# 2. Track previous node to find violations where prev.val > current.val.
# 3. Swap the values of the two misplaced nodes to recover the BST.

from typing import Optional

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def recoverTree(self, root: Optional['TreeNode']) -> None:
        first = second = prev = None

        def inorder(node):
            nonlocal first, second, prev
            if not node:
                return
            inorder(node.left)
            if prev and prev.val > node.val:
                if not first:
                    first = prev
                second = node
            prev = node
            inorder(node.right)
        
        inorder(root)
        if first and second:
            first.val, second.val = second.val, first.val