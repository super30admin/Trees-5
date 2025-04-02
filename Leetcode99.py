# Time Complexity: O(n)
# Space Complexity: O(logn)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        self.first = self.last = self.prev = None
        self.dfs(root)
        self.first.val, self.last.val = self.last.val, self.first.val
    def dfs(self, root):
        if not root:
            return
        self.dfs(root.left)
        if self.prev and root.val < self.prev.val:
            if not self.first:  # First incorrect node
                self.first = self.prev
            self.last = root  # Last incorrect node

        self.prev = root  # Move prev pointer forward

        self.dfs(root.right)