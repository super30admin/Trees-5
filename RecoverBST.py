# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Recursive and Iteative
# Time Complexity: O(n)
# Space Complexity: O(n)
class Solution:
    def __init__(self):
        self.first = None
        self.second = None
        self.prev = TreeNode(float('-inf'))
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.inOrder(root)
        # Swap the values of the two misplaced nodes
        self.first.val, self.second.val = self.second.val, self.first.val

    def inOrder(self, root):
        # base
        if root is None:
            return
        # logic
        self.inOrder(root.left)
        if self.prev != None and self.prev.val >= root.val:
            if self.first is None:
                self.first = self.prev
            self.second = root
        self.prev = root
        self.inOrder(root.right)