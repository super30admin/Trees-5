# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# TC : O(N)
# SC : O(H)
class Solution(object):

    def recoverTree(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: None Do not return anything, modify root in-place instead.
        """

        self.prev = None
        self.first = None
        self.second = None

        if root is None:
            return

        self.inorder(root)
        temp = self.first.val
        self.first.val = self.second.val
        self.second.val = temp

    def inorder(self, root):

        if root is None:return

        self.inorder(root.left)

        if self.prev is not None and self.prev.val >= root.val:
            if self.second is None:
                self.first = self.prev
                self.second = root
            else:
                self.second = root

        self.prev = root
        self.inorder(root.right)






