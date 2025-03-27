"""
Iterative approach (throwing error) --

TC = O(n) since traversing through the entire tree
SC = O(h) since stack space
"""

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
        if not root: return None

        # initialize variables
        self.prev = None
        self.first = None
        self.second = None
        self.stack = []

        while root and self.stack:
            while root is not None:
                self.stack.push(root)
                root = root.left
            # once all elements process in left subtree
            root = self.stack.pop()

            if self.prev and self.prev.val >= root.val:
                if self.first is None:
                    # first mismatch
                    self.first = self.prev
                self.second = root
            self.prev = root

            # traverse right sub tree
            root = root.right

        # swap mismatched values
        self.first.val, self.second.val = self.second.val, self.first.val