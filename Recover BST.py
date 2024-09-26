# Time:- O(n)
# Space:- O(h) h=height of the tree
# Approach:- Use the property of BST,while doing inorder traversal if left>=root this is a violation, now there can be 2 violations if we find another violation we will make the 2 violation as the next violation we find.
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
        def inorder(root):
            if root is None:
                return
            inorder(root.left)
            if self.prev and self.prev.val>=root.val:
                if not self.first:
                    self.first=self.prev
                    self.last=root
                else:
                    self.last=root
            self.prev=root
            inorder(root.right) 
        if root is None:
            return
        self.prev=self.first=self.last=None
        inorder(root)
        self.first.val,self.last.val=self.last.val,self.first.val
        
        
        
        
        