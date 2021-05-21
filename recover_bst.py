# Time Complexity: O(n) where n is the number of nodes
# Space Complexity: O(h) where h is the height of tree
# Ran on Leetcode: Yes

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
        if not root:
            return
        self.first = None
        self.last = None
        self.prev = None
        self.isFirst = False
        self.inorder(root)
        temp = self.first.val
        self.first.val = self.last.val
        self.last.val = temp
        
    def inorder(self, root):
        if not root:
            return
        self.inorder(root.left)
        if self.prev and self.prev.val >= root.val:
            if not self.isFirst:
                self.first = self.prev
                self.last = root
                self.isFirst = True
            else:
                self.last = root
        self.prev = root
        self.inorder(root.right)