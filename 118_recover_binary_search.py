# Time complexity - O(n)
# Space complexity - O(h)

# Approach - Similar to validate BST, only maintain two variables first and second to note the first and
# second breach (in BST property) respectively. Once dfs done, swap values of first and second.

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
        if root == None:
            return

        self.prev = None
        self.first = None
        self.second = None
        self.dfs(root)
        self.first.val, self.second.val = self.second.val, self.first.val
    
    def dfs(self, root: Optional[TreeNode]) -> None:
        if root == None:
            return
        self.dfs(root.left)
        if self.prev != None and self.prev.val > root.val:
            if self.first == None:
                self.first = self.prev
            self.second = root
        self.prev = root
        self.dfs(root.right)