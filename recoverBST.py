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
        # T: O(n), S: O(n)
        first = second = prev = None

        def inorder(node):
            nonlocal first, second, prev
            if not node:
                returnÏ

            inorder(node.left)

            if prev and node.val < prev.val:
                if not first:
                    first = prev
                second = node

            prev = node
            inorder(node.right)

        inorder(root)
        first.val, second.val = second.val, first.val
