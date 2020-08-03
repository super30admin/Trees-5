# Time Complexity : Add - O(n)
# Space Complexity :O(h)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''
1. Use prev pointer to detect a breach, and store the breached nodes as global first and last
2. If only 1 breach is discoveredm swap the first and last, if not
3. If 2 breach is present update last to new breach node, and then swap
'''


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    prev = None
    isBreach = False
    first = None
    last = None
    def recoverTree(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.prev, self.first, self.last = None, None, None
        self.isBreach = False
        self._helper(root)
        
        self.first.val, self.last.val = self.last.val, self.first.val
        
    def _helper(self, root):
        
        if root is None:
            return
        
        self._helper(root.left)
       
        if self.prev is not None and self.prev.val >= root.val:
            if self.isBreach == False:
                self.isBreach = True
                self.first = self.prev
                self.last = root
            
                # print(self.first, self.last)
            else:
                self.last = root
        
        self.prev = root

        self._helper(root.right)
    
        
        