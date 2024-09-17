# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def __init__(self):
        self.first=None
        self.last=None
        self.prev=None
        self.flag=None
    def recoverTree(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if root==None:
            return
        self.inorder(root)
        temp=self.first.val
        self.first.val=self.last.val
        self.last.val=temp
        
    def inorder(self,root):
        if root==None:
            return
        self.inorder(root.left)
        
        if self.prev!=None and self.prev.val>=root.val:
            if not(self.flag):
                self.flag=True
                self.first=prev
                self.last=root
            else:
                self.last=root
        prev=root
        self.inorder(root.right)
        
Time complexity is O(n)
