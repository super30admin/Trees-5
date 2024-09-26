"""
Time Complexity : O(n)
Space Complexity : O(1) [O(h) - stack space]
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this: none
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def __init__(self):
        self.first = None
        self.middle = None
        self.last = None
        self.prev = None
        
    def recoverTree(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if not root:
            return
        
        self.traverse(root)
        if not self.last:
            temp = self.first.val
            self.first.val = self.middle.val
            self.middle.val = temp
        else:
            temp = self.first.val
            self.first.val = self.last.val
            self.last.val = temp
            
    def traverse(self, root):
        # base case
        if not root or self.last:
            return
        
        # logic
        self.traverse(root.left)
        if self.prev:
            if self.prev.val > root.val:
                if not self.first and not self.middle:
                    self.first = self.prev
                    self.middle = root
                else:
                    self.last = root
        self.prev = root
        self.traverse(root.right)