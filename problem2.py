'''
Title Recover Binary Search Tree
Time Complexity: O(n)
Space Complexity: O(n)
Did this code successfully run on Leetcode : Yes
Explanation: Do Inorder Traversal and while traversing check if previous Value>current value, if this is true and its
the first time then previous value is the first Node to replace and if its the second time then the current node is the
next node to be replaced with.
'''


import math


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def __init__(self):
        self.firstNode = None
        self.secondNode = None
        self.previousNode = None

    def inOrder(self, root: TreeNode) -> None:
        if root == None:
            return

        self.inOrder(root.left)

        if self.firstNode == None and self.previousNode.val > root.val:
            self.firstNode = self.previousNode

        if self.firstNode != None and self.previousNode.val > root.val:
            self.secondNode = root

        self.previousNode = root

        self.inOrder(root.right)

    def recoverTree(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if root == None:
            return None

        self.previousNode = TreeNode(-math.inf)
        self.inOrder(root)
        self.swap(self.firstNode, self.secondNode)

    def swap(self, node1: TreeNode, node2: TreeNode) -> None:
        temp = node1.val
        node1.val = node2.val
        node2.val = temp