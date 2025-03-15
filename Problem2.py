# Problem 2 : Recover Binary Search Tree
# Time Complexity : 
'''
Recursion - O(n) where n is the number of nodes in the tree
Iterative - O(h) where h is the height of the tree
'''
# Space Complexity : 
'''
Recursion - O(n) where n is the number of nodes in the tree
Iterative - O(h) where h is the height of the tree
'''
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach

# Recursive
from typing import Optional
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        # if the root is None then return. Base case
        if root is None: return
        # define the prev, first and second variable to None
        prev = None
        first = None
        second = None

        # in-order function over root node
        def inorder(root: Optional[TreeNode]) -> None:
            # first, second and prev are global variable
            nonlocal first, second, prev
            # if the root is None then reurn
            if root is None: return
            # call the inorder function for left child of the root
            inorder(root.left)
            # check if the prev is not None and if the value of prev is greater than root(it is breach)
            if (prev != None and prev.val > root.val):
                # if it is breach then check if this is first breach by checking if the first is None
                if (first is None):
                    # set the first to prev and second to root
                    first = prev
                    second = root
                # else means this is second breach then set the second to root
                else:
                    second = root
            # set the prev to root for next step
            prev = root
            # call inorder for right child of the root 
            inorder(root.right)

        # call inorder for the root 
        inorder(root)
        # swap the first and second node of the tree to recover the binary search tree
        temp = first.val
        first.val = second.val
        second.val = temp

# Iterative
from typing import Optional
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        # if the root is None then return. Base case
        if root is None: return
        # define the prev, first and second variable to None
        prev = None
        first = None
        second = None
        # define the stack for storing the node 
        stack = []
        # set the current to root of the tree
        current = root
        # loop utnil stack is not empty or current node is not None
        while stack or current:
            # loop until current is not None
            while current:
                # append the current node to the stack
                stack.append(current)
                # set the current to left child of the current node
                current = current.left
            # pop the element of the stack
            current = stack.pop()
            # check if the prev is None and the value of the prev is greater than the current
            if prev and prev.val >= current.val:
                # check if this is first breach by checking if the first is None
                if first is None:
                    # set the frist and second variable
                    first = prev
                    second = current
                # if this second breach then set the second variable
                else:
                    second = current
            # set the prev to current node
            prev = current
            # move current to right child of the current node
            current = current.right

        # swap the first and second variable to recover the binary search tree
        temp = first.val
        first.val = second.val
        second.val = temp