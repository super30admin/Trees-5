# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def recoverTree(self, root):
        """
        :type root: TreeNode
        :rtype: None Do not return anything, modify root in-place instead.
        """
        #time is O(n)
        # space is O(h)
        self.prev = None
        self.first = None
        self.last = None
        self.flag = False
        def inorder(root):
            #base
            if root is None:
                return
            #logic
            inorder(root.left)
            # condition for breach
            if self.prev is not None and self.prev.val >= root.val:
                # flag to find if first breach found
                if not self.flag:
                    # setting last flag too just in case the second breach is never found
                    self.first = self.prev
                    self.last = root
                    self.flag = True
                else:
                    self.last = root
                #setting prev
            self.prev = root
            inorder(root.right)
        inorder(root)
        #doing the swap
        temp = self.first.val
        self.first.val = self.last.val
        self.last.val = temp
