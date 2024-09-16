"""
// Time Complexity : O(n), 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : NO, unable to figure out the mistake. Help needed.
// Any problem you faced while coding this : no
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def inorder(self, root):
        if not root:
            return
        flag = False
        
        prev = None
        #cur = root
        self.inorder(root.left)
        
        if prev and prev.val >= root.val: #breach
            print("here")
            if flag == False:
                print(prev.val)
                self.first = prev
                self.last = root
                flag = True
                
            elif flag == True:
                self.last = root
        
        prev = root
        self.inorder(root.right)
            
    def recoverTree(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.first = None
        self.last = None
        
        self.inorder(root)
        
        tmp = self.first.val
        self.first.val = self.last.val
        self.last.val = tmp
        