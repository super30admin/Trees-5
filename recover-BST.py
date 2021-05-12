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
        if root is None:
            return
        first = last = prev = None
        is_first = False

        def inorder(node):
            nonlocal first, last, prev, is_first
            if node is None:
                return
            inorder(node.left)
            if prev is not None and prev.val >= node.val:
                if not is_first:
                    first = prev
                    last = node
                    is_first = True
                else:
                    last = node
            prev = node
            inorder(node.right)

        inorder(root)
        temp = first.val
        first.val = last.val
        last.val = temp
