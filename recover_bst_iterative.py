"""
Time Complexity : O(n) where n is the total number of nodes in the tree. In worst case we have to traverse all the nodes in the tree
Space Complexity : O(h) where h is the height of the tree. In worst case the recursive stack can have at max h elements
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution:
    def __init__(self):
        self.first = None
        self.second = None
        self.prev = None

    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if root == None:
            return root

        self.helper(root)
        temp = self.first.val
        self.first.val = self.second.val
        self.second.val = temp

    def helper(self, root):
        stack = []

        while len(stack) > 0 or root != None:
            while root != None:
                stack.append(root)
                root = root.left

            root = stack.pop()

            if self.prev != None and self.prev.val >= root.val:
                if self.first == None:
                    self.first = self.prev
                    self.second = root
                else:
                    self.second = root
            self.prev = root
            root = root.right
