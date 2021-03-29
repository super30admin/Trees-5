# Created by Aashish Adhikari at 1:20 PM 3/29/2021
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

'''
Time Complexity:
O(n) where n is the number of nodes in the tree.
Space Complexity:
O(1)
'''

class Solution(object):

    def inorder(self, node):

        # base case
        if node is None:
            return


        # logic
        self.inorder(node.left)

        if self.prev is not None and self.prev.val >= node.val:

            if not self.flag:
                # first breach
                self.first = self.prev
                self.last = node
                self.flag = True
            else:
                self.last = node

        self.prev = node

        self.inorder(node.right)


    def recoverTree(self, root):
        """
        :type root: TreeNode
        :rtype: None Do not return anything, modify root in-place instead.
        """


        self.flag = False # to detect if its the first breach or the second breach
        self.prev = None
        self.first = None
        self.last = None

        self.inorder(root)

        temp = self.last.val
        self.last.val = self.first.val
        self.first.val = temp











