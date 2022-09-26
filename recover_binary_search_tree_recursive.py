# Time Complexity : O(N) whenre N is number of Nodes in the tree
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.first = None
        self.second = None
        self.flag  = False
        self.prev = None
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.inOrderTraverse(root)
        
        self.first.val , self.second.val = self.second.val,  self.first.val
        
        return root
        
    def inOrderTraverse(self, root):
        #base
        if root == None:
            return
        
        #logic
        
        
        self.inOrderTraverse(root.left)
        
        if self.prev != None and self.prev.val >= root.val:
            if self.flag:
                self.second = root
            else:
                self.flag = True
                self.first = self.prev
                self.second = root
        
        self.prev = root
        
        self.inOrderTraverse(root.right)