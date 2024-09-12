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
        
        self.found_first = False
        self.last, self.first = TreeNode(),TreeNode()
        self.prev = None
        self.inorder(root)
        self.first.val,self.last.val = self.last.val, self.first.val
        
        return root
    
    
    def inorder(self,node):
        
        #base
        if not node:
            return        
        
        #Logic
        
        self.inorder(node.left)        
        
        if self.prev  and node.val <= self.prev.val:            
            if self.found_first:            
                self.last = node            
            else:
                self.first = self.prev
                self.found_first = True
                self.last = node 
        self.prev = node    
        
        self.inorder(node.right)
        
        
        
        
        
