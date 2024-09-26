"""
Time Complexity : O(n)
Space Complexity : O(h) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach:
Here, we traverse through the tree, and find the 2 breaches and store them in first and last. When done traversing,
we just swap the values.
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution:
    def recoverTree(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.first, self.last, self.prev = None, None, None
        self.dfs(root)
        self.first.val, self.last.val = self.last.val, self.first.val
        return root

    def dfs(self, root):
        if not root:
            return
        self.dfs(root.left)
        if self.prev and self.prev.val >= root.val:
            if not self.first:
                self.first = self.prev
                self.last = root
            else:
                self.last = root
        self.prev = root
        self.dfs(root.right)
