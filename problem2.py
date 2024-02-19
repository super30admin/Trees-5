# Time Complexity :O(N)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode :yes

# Definition for a binary tree node.
class TreeNode:
     def __init__(self, val=0, left=None, right=None):
         self.val = val
         self.left = left
         self.right = right
from typing import Optional


class Solution:

    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if not root:
            return None
        
        self.first, self.second, self.prev = None, None, None
        self.inorder(root)
        if self.first and self.second:
            self.first.val, self.second.val = self.second.val, self.first.val
          
    def inorder(self, root):
        if not root:
            return None
        
        self.inorder(root.left)
        if self.prev and self.prev.val >= root.val:
            if not self.first:
                self.first = self.prev
            self.second = root
        self.prev = root
        self.inorder(root.right)



        


        
        