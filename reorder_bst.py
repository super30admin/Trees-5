# // Time Complexity :O(n)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.prev=None
        self.first=None
        self.second=None
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.inorder(root)
        self.first.val,self.second.val=self.second.val,self.first.val
    def inorder(self,root):
        #base
        if root is None:
            return
        
        #logic
        
        self.inorder(root.left)
        if self.prev is not None:
            print(self.prev.val,root.val)
        if(self.prev is not None and self.prev.val>root.val):
            
            if self.first is None:
                self.first=self.prev
                self.second=root
            else:
                self.second=root
            print("first",self.first.val)
            print("second",self.second.val)
        self.prev=root
        self.inorder(root.right)
        
        
        