"""
Time - O(n)
Space - O(1)

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
        first = second = prev = None

        def inorder(root):
            nonlocal first, second, prev
            # base
            if root is None:
                return

            # left
            inorder(root.left)

            # root
            if prev and prev.val >= root.val:
                if first is None:
                    first = prev
                second = root
            prev = root

            # right
            inorder(root.right)

        inorder(root)

        # swap values
        first.val, second.val = second.val, first.val
