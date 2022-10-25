#Time: O(n)
#Space: O(n)
#Program ran on leetcode successfully

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.first = None
        self.middle = None
        self.last = None
        self.prev = None 
        
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        
        self.helper(root)
        if self.first and self.last:
            self.first.val, self.last.val = (self.last.val, self.first.val)
        elif self.first and self.middle:
            self.first.val, self.middle.val = (self.middle.val, self.first.val)
    
    def helper(self, root):
        if root:
            self.helper(root.left)
            if self.prev and root.val < self.prev.val:
                if not self.first:
                    self.first = self.prev
                    self.middle = root
                else:
                    self.last = root
            self.prev = root
            self.helper(root.right)
                
        