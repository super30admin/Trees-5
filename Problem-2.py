'''
    Time Complexity: O(n)
    Space Complexity: O(logn)
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.first = self.second = self.prev = None

    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.helper(root)
        self.first.val, self.second.val = self.second.val, self.first.val

    def helper(self, node):
        # base case
        if not node:
            return

        # logic
        self.helper(node.left)

        if self.prev and node.val < self.prev.val:
            if not self.first:
                self.first = self.prev
            self.second = node

        self.prev = node

        self.helper(node.right)

    
        