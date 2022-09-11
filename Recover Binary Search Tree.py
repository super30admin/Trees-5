# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# TC: O(n)
# SC: O(h)
class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if not root:
            return
        
        self.first = None
        self.second = None
        self.prev = None
        self.flag = False
        
        def inorder(root):
            #Base
            if not root:
                return
            #Logic
            inorder(root.left)
            
            if self.prev and self.prev.val > root.val:
                if self.flag == False:
                    # First breach
                    self.flag = True
                    self.first = self.prev
                    self.second = root
                else:
                    self.second = root
            self.prev = root
            inorder(root.right)
        
        inorder(root)
        
        self.first.val, self.second.val = self.second.val, self.first.val # Swap values of nodes we stored in first and second