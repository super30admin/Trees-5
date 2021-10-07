"""
Time Complexity : O(n) where n is the number of nodes in the BST
Space Complexity : O(H) where H is the height of the BST
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
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
        self.first = None
        self.last = None
        self.prev = None
        self.mismatch = False
        if not root:
            return 
        self.inorder(root)
        # Swap the nodes recorded from inorder traversal that are not in place
        temp = self.first.val
        self.first.val = self.last.val
        self.last.val = temp
    def inorder(self, root):
        # Base
        if not root:
            return
        # Logic
        self.inorder(root.left)
        # If we see that the prev pointer value us greater than the root which is the 
        # next element of the traversal and if the mismatch is occuring for the very
        # first time we record the first anf last values as prev and root 
        # respectively. If the mismatch has occured before then we simply update last
        if self.prev != None and self.prev.val >= root.val:
            if not self.mismatch:
                self.first = self.prev
                self.last = root
                self.mismatch = True
            else:
                self.last = root
                return
        self.prev = root
        self.inorder(root.right)