# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Time Complexity: O(n)
# Space Complexity: O(h)
class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if not root:
            return None
        self.first = None
        self.second = None
        self.prev = None

        self.inorder(root)

        temp = self.first.val
        self.first.val = self.second.val
        self.second.val = temp

        return root

    def inorder(self, root):
        if not root:
            return

        self.inorder(root.left)
        if self.prev is not None and self.prev.val >= root.val:
            if self.first is None:
                self.first = self.prev
                self.second = root
            else:
                self.second = root
                return

        self.prev = root
        self.inorder(root.right)
        return
