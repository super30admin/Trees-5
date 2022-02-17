# TimeComplexity o(N)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def __init__(self,first = None,second = None,prev = None):
        
        self.first = None
        self.second = None
        self.prev = None
        
        
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        
        if root == None:
            return

        self.inorder(root)
        
        temp = self.first.val
        
        self.first.val = self.second.val
        
        self.second.val = temp
    
    
    def inorder(self,root):
        
        if root == None:
            return
        
        self.inorder(root.left)
        
        if self.prev != None and self.prev.val >= root.val:
            
            if self.second == None and self.first == None:
                
                self.first = self.prev
                self.second = root
            else:
                self.second = root
        self.prev = root
        
        self.inorder(root.right)
        
        