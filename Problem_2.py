# Runs on leetcode
# Memory complexity - O(1), runtime complexity - O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def __init__(self):
        self.prev, self.first, self.middle, self.last = None, None, None, None
        
    def recoverTree(self, root: TreeNode) -> None:
        self.helper(root)
        if self.first and self.last:
            self.first.val, self.last.val = self.last.val, self.first.val
        elif self.first and self.middle:
            self.first.val, self.middle.val = self.middle.val, self.first.val
        
    def helper(self, root):
        # edge case
        if not root:
            return 
        # logic
        self.helper(root.left)
        if self.prev and self.prev.val > root.val:
            if not self.first:
                self.first = self.prev
                self.middle = root
            else:
                self.last = root
                
        self.prev = root
        self.helper(root.right)
