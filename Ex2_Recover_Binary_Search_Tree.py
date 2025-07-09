# ----------------------------------------------------
# Intuition:
#
# In a valid BST, inorder traversal should give a sorted sequence.
# If exactly two nodes are swapped, the sorted order will be violated at most twice.
# By doing an inorder traversal, we can detect the misplaced nodes and swap their values.
#
# 1.   Optimal - Recursive Inorder:
#    - Perform inorder traversal and track previous node.
#    - If a previous node has a greater value than the current node,
#      then a violation is detected.
#    - First violation → store previous as 'first', current as 'second'.
#    - Second violation → update 'second' to current node.
#    - Swap values of 'first' and 'second' at the end.
#    → Time: O(n), Space: O(h) for recursion stack.
#
# 2.   Iterative Inorder using Stack:
#    - Same idea but avoid recursion using an explicit stack.
#    → Time: O(n), Space: O(h)
#
# 3.   Naive Brute Force:
#    - Do full inorder traversal and store nodes in list.
#    - Sort the values and reassign them to the tree nodes.
#    → Time: O(n log n), Space: O(n)
# ----------------------------------------------------

from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        # ----------------------------------------------------
        # Optimal: Recursive Inorder Traversal (O(n) time, O(h) space)
        # ----------------------------------------------------
        self.first = self.second = self.prev = None

        def inorder(node):
            if not node:
                return
            inorder(node.left)
            if self.prev and self.prev.val > node.val:
                if not self.first:
                    self.first = self.prev
                self.second = node
            self.prev = node
            inorder(node.right)

        inorder(root)
        if self.first and self.second:
            self.first.val, self.second.val = self.second.val, self.first.val

        # ----------------------------------------------------
        # Iterative Inorder using Stack
        # ----------------------------------------------------
        # stack = []
        # first = second = prev = None
        # curr = root

        # while stack or curr:
        #     while curr:
        #         stack.append(curr)
        #         curr = curr.left

        #     curr = stack.pop()
        #     if prev and prev.val > curr.val:
        #         if not first:
        #             first = prev
        #         second = curr
        #     prev = curr
        #     curr = curr.right

        # if first and second:
        #     first.val, second.val = second.val, first.val

        # ----------------------------------------------------
        # Naive Brute Force: Store inorder nodes and sort
        # ----------------------------------------------------
        # nodes = []
        # def inorder(node):
        #     if not node:
        #         return
        #     inorder(node.left)
        #     nodes.append(node)
        #     inorder(node.right)
        # inorder(root)

        # vals = [node.val for node in nodes]
        # vals.sort()
        # for i in range(len(nodes)):
        #     nodes[i].val = vals[i]
