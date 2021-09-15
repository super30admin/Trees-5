"""
//Time Complexity : O(N)
// Space Complexity :O(Height)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this : NO
"""


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def recoverTree(self, root):
        """
        :type root: TreeNode
        :rtype: None Do not return anything, modify root in-place instead.
        """
        if root is None:
            return 
        self.prev,self.first,self.last = None,None,None
        self.mismatch = False
        self.inorder(root)
        self.first.val,self.last.val = self.last.val,self.first.val
    def inorder(self,root):
        #base
        if root == None:
            return
        #logic
        self.inorder(root.left)
        if(self.prev!=None and self.prev.val >= root.val):
            if(self.mismatch == False):
                self.first = self.prev
                self.last = root
                self.mismatch = True
            else:
                self.last = root 
                return
        self.prev = root
        self.inorder(root.right)
        
        
        
        