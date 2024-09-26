
"""
Time Complexity: O(N)
Space Complexity: O(1) [O(N) Recursive stack space]
Compiled on Leetcode?: Yes
"""
class Solution:
    def __init__(self):
        self.prev = TreeNode(float('-inf'))
        self.first = None
        self.middle = None
        self.last = None
        
    def recoverTree(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.inorder(root)
        if self.last:
            temp = self.last.val
            self.last.val = self.first.val
            self.first.val = temp
        else:
            temp = self.first.val
            self.first.val = self.middle.val
            self.middle.val = temp
        
    
    def inorder(self, root):
        if root is None:
            return
        self.inorder(root.left)
        if root.val < self.prev.val:
            if self.first is None:
                self.first = self.prev
                self.middle = root
            else:
                self.last = root
        else:
            self.prev = root
        self.inorder(root.right) 