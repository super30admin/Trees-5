# // Time Complexity : O(n) where n is the number of nodes. 
# // Space Complexity : O(1).
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Class Solution.

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
        self.first = None
        self.second = None
        self.prev =None
        def inorder(root):
            # base
            if root == None:
                return 
            
            #logic
            inorder(root.left)
            # check
            if self.prev != None and self.prev.val >= root.val:
                # first violation
                if self.second == None:
                    self.first = self.prev
                    self.second = root
                else:
                    self.second = root
            self.prev = root
            
            inorder(root.right)
        inorder(root)
        self.first.val, self.second.val = self.second.val, self.first.val
