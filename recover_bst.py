#Time Complexity: O(N)

#Space Complexity: O(H) 

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
        if not root:
            return
        
        self.prev = None
        self.first = None
        self.last = None
        self.flag = False
        def inorder(root):
            if not root:
                return
            
            inorder(root.left)
            if self.prev and self.prev.val>root.val:
                if not self.flag: #first breach
                    self.first = self.prev
                    self.last = root
                    self.flag = True
                else: #second breach
                    self.last = root
            self.prev = root
            inorder(root.right)
            
        
        inorder(root)
        temp = self.first.val
        self.first.val = self.last.val
        self.last.val = temp