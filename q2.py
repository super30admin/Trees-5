# Time Complexity : O(n), Where n is number of elements in the binary tree
# Space Complexity : O(h), Where h is the height of the binary tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nothing specific
from typing import Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def __init__(self):
        self.prev=None
        self.first=None
        self.second=None
    def inorder(self,root):
        if(root==None):
            return
        
        self.inorder(root.left)
        if(self.prev!=None and self.prev.val>=root.val):
            if(self.first!=None):
                #This will set first,second when it finds abnormal for second time
                self.second=root
            else:
                #This will set first, second when it finds abnormal for first time 
                self.first=self.prev
                self.second=root
        self.prev=root
        self.inorder(root.right)
        
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.inorder(root)
        #print(self.first,self.second)
        #Swapping the first and second elements
        self.first.val,self.second.val=self.second.val,self.first.val