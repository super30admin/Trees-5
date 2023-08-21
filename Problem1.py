#Time Complexity :O(n)
#Space Complexity :O(h)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    prev=None
    first=None
    Second=None
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.inorder(root)
        temp=self.first.val
        self.first.val=self.second.val
        self.second.val=temp

    def inorder(self,root):
        if root==None:
            return
        
        self.inorder(root.left)
        
        if self.prev!=None and self.prev.val>root.val:
            if self.first==None:
                self.first=self.prev
                self.second=root
            else:
                self.second=root
        self.prev=root

        self.inorder(root.right)
        