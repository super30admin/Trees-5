# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#TC : O(n)
#SC : O(h)
#As we know inorder travelsal is always sorted for BST, we keep prev and root and check for breach
#maybe there are two breaches, in this case we consider the second one

class Solution(object):
    first = None
    second = None
    prev = None
    def recoverTree(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: None Do not return anything, modify root in-place instead.
        """
        if not root: return
        self.inorder(root)
        temp = self.first.val
        self.first.val = self.second.val
        self.second.val = temp

    def inorder(self, root):
        if not root: return
        self.inorder(root.left)
        if self.prev and root.val < self.prev.val:
            #first breach
            if self.first is None:
                self.first = self.prev
                self.second = root
            else:
                self.second = root
        self.prev = root
        self.inorder(root.right)