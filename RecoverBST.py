# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# TC - O(n)
# SC - O(1)
class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        """
        :type root: TreeNode
        :rtype: None Do not return anything, modify root in-place instead.
        """

        def dfs(root):
            nonlocal first, second, prev, isFirst

            if not root:
                return None

            dfs(root.left)

            if prev and prev.val > root.val:
                if not isFirst:
                    first = prev
                    second = root
                    isFirst = True
                else:
                    second = root

            prev = root

            dfs(root.right)

        prev = None
        isFirst = False
        first, second = None, None
        dfs(root)
        first.val, second.val = second.val, first.val
