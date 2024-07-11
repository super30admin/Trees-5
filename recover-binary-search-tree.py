# Time Complexity : O(n)
# Space Complexity : O(h)
from typing import Optional, TreeNode
class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.first = None
        self.second = None
        self.prev = None

        def inorder(root):
            if root == None:
                return
            
            inorder(root.left)
            if self.prev!=None and root.val < self.prev.val:
                if self.first == None:
                    self.first = self.prev
                    self.second = root
                else:
                    self.second = root
            self.prev = root
            inorder(root.right)

        inorder(root)
        temp = self.first.val
        self.first.val = self.second.val
        self.second.val = temp
