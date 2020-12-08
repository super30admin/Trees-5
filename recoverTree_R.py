"""
Time complexity is O(N)
Space complexity is O(H) O(Log N)


"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def recoverTree(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if root is None:
            return
        self.first=None 
        self.last=None
        self.prev=None
        self.inorder(root)
        temp=self.first.val
        self.first.val=self.last.val
        self.last.val=temp
        
    def inorder(self,root):
        if(root is None):
            return
        
        self.inorder(root.left)
        #st.pop()
        if(self.prev and self.prev.val>=root.val):
            #how do we know if its a first breach
            if(self.first is None):
                self.first=self.prev
                self.last=root
            else:
                self.last=root
        self.prev=root
        self.inorder(root.right)

        