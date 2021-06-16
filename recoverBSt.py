# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.first = None
        self.last = None
        self.flag = False
        self.prev = None

    def recoverTree(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.inorder(root)
        temp = self.first.val
        self.first.val = self.last.val
        self.last.val = temp

    def inorder(self, root):
        if root is None: return

        self.inorder(root.left)
        if self.prev is not None and self.prev.val >= root.val:
            if self.flag != True:
                self.first = self.prev
                self.last = root
                self.flag = True
            else:
                self.last = root
        self.prev = root

        self.inorder(root.right)




