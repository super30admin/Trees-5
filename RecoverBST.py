#99. Recover Binary Search Tree
"""
Time Complexity : O(n)
Space Complexity : O(h)
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    prev = None
    first = None
    second = None
    
    def helper(self, root):
        #base
        if root == None:
            return
            
        #logic
        self.helper(root.left)
        if self.prev != None and self.prev.val >= root.val:
            if self.first == None:
                self.first = self.prev
                self.second = root
            else:
                self.second = root
                
        self.prev = root
        self.helper(root.right)
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.prev = None
        self.first = None
        self.second = None
        self.helper(root)
        
        self.first.val, self.second.val = self.second.val, self.first.val
