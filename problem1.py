# Time Complexity: O(n)
# Space Complexity: O(n)
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
        self.first_node = None
        self.second_node = None
        self.prev = None

        self.inorder(root)
        if self.first_node is not None and  self.second_node is not None:
            self.first_node.val, self.second_node.val = self.second_node.val, self.first_node.val

    def inorder(self,root):
        if root is None: return

        self.inorder(root.left)

        if self.prev and self.prev.val > root.val:
            if self.first_node is None:
                self.first_node = self.prev
            self.second_node = root

        self.prev = root
        self.inorder(root.right)
