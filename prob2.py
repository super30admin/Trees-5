# Time Complexity :O(n)
# Space Complexity :O(h)
# Leet Code: Yes

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
        self.prev = self.first = self.second = None
        self.inorderTraversal(root)
        self.first.val, self.second.val = self.second.val, self.first.val
    
    def inorderTraversal(self, root):
        if root is None:
            return
        
        self.inorderTraversal(root.left)
        if self.prev is not None and root.val < self.prev.val:
            if self.first is None:
                self.first = self.prev
                self.second = root
            else:
                self.second = root
        self.prev = root
        self.inorderTraversal(root.right)
        