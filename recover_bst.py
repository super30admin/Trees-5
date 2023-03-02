# Time Complexity : O(N)
# Space Complexity : O(H) H is height of tree

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    first = None
    second = None
    prev = None

    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if not root:
            return

        def helper(root):
            if not root:
                return
            helper(root.left)
            if self.prev and self.prev.val > root.val:
                if not self.second:
                    self.second = root
                    self.first = self.prev
                else:
                    self.second = root
            self.prev = root
            helper(root.right)

        helper(root)
        print(self.first, self.second)
        self.first.val, self.second.val = self.second.val, self.first.val
        return
