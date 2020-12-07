#Time Complexity : O(n) where n is the number of nodes in the tree
#Space Complexity : O(n) where n is the number of nodes in the tree
#Did this code successfully run on Leetcode : Yes

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def helper(self, root):
        if root is None:
            return
        self.helper(root.left)
        if self.prev and self.prev.val >= root.val:
            if self.first is None:
                self.first = self.prev
            self.last = root

        self.prev = root
        self.helper(root.right)

    def recoverTree(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.first, self.last, self.prev = None, None, None

        self.helper(root)
        self.first.val, self.last.val = self.last.val, self.first.val
