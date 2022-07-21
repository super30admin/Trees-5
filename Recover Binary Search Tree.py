# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def recoverTree(self, root):
        """
        :type root: TreeNode
        :rtype: None Do not return anything, modify root in-place instead.
        """
        self.first = None
        self.second = None
        self.prev = None
        self.inOrder(root)
        self.first.val, self.second.val = self.second.val, self.first.val
        
    def inOrder(self,root):
        if not root:
            return
        
        self.inOrder(root.left)
        
        if self.prev:
            if self.prev.val > root.val:
                if not self.first:
                    self.first = self.prev                    
                self.second = root
                
        self.prev = root
        
        self.inOrder(root.right)