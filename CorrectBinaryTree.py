#Time complexity: O(n)
#Space complexity: O(1)

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
        self.prev=None
        self.first,self.second=None, None
        self.helper(root)
        
        self.first.val, self.second.val=self.second.val,self.first.val
        
        
    def helper(self,root):
        if root==None:
            return
        self.helper(root.left)
        if(self.prev and self.prev.val > root.val):
            if not self.first and not self.second:
                self.first=self.prev
                self.second=root
            else:
                self.second=root
        self.prev=root
        self.helper(root.right)
        