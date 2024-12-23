# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self, val=0, left=None, right=None):
        self.prev = None
        self.first = None
        self.second = None

    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.helper(root)

        if self.first and self.second:
            self.first.val, self.second.val = self.second.val, self.first.val

    def helper(self, root):
        if not root:
            return

        self.helper(root.left)

        if self.prev and self.prev.val > root.val:
            if not self.first:
                self.first = self.prev
            self.second = root

        self.prev = root
        self.helper(root.right)


# time complexity is O(n)
# space complexity is O(1)
