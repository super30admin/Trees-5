# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    """using previous and current pointer which is used in validate BST problem
    Time complexity-O(n)
    Space complexity-O(h) which utilizes the recursive stack"""
    def __init__(self):
        self.first=-1
        self.last=-1
        self.prev=None
        self.flag=False
    def recoverTree(self, root: TreeNode) -> None:
        if not root:
            return
        self.inOrder(root)
        self.first.val, self.last.val=self.last.val, self.first.val
        
    def inOrder(self, root):
        if not root:
            return
        self.inOrder(root.left)
        if self.prev!=None and self.prev.val>root.val:
            if self.flag!=True:
                self.first=self.prev
                self.last=root
                self.flag=True
            else:
                self.last=root
        self.prev=root
        self.inOrder(root.right)
        
        