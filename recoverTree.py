# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#TC: O(n)
class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.first = None
        self.second = None
        self.prev = None
        
        q = []
        while root or q:
            while root:
                q.append(root)
                root = root.left
            root = q.pop(0)
            if self.prev != None and self.prev.val >= root.val:
                if not self.first:
                    self.first = self.prev
                    self.second = root
                else:
                    self.second = root
            self.prev = root
            root = root.right
    
#         def inorder(node):
#             if not node:
#                 return
#             inorder(node.left)
#             if self.prev != None and self.prev.val >= node.val:
#                 if not self.first:
#                     self.first = self.prev
#                     self.second = node
#                 else:
#                     self.second = node
#             self.prev = node
#             inorder(node.right)
        
#         inorder(root)
        self.first.val, self.second.val = self.second.val, self.first.val
  
