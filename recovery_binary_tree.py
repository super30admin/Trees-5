# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    # def inorder(self,root):
    #         if not root:
    #             return
    #         self.inorder(root.left)
    #         if self.prev!=None and self.prev.val>root.val:
    #             if self.first==None:
    #                 self.first=self.prev
    #                 self.last=root
    #             else:
    #                 self.last=root
    #         self.prev=root
    #         self.inorder(root.right)

    def inorder(self, root):
        if not root:
            return
        stack = []
        # stack.append(root)
        while root or stack:
            while root:
                stack.append(root)
                root = root.left
            root = stack.pop()
            if self.prev != None and self.prev.val > root.val:
                if self.first == None:
                    self.first = self.prev
                    self.last = root
                else:
                    self.last = root
            self.prev = root
            # if root.right:
            root = root.right
        # self.inorder(root.right)

    def recoverTree(self, root):
        """
        :type root: TreeNode
        :rtype: None Do not return anything, modify root in-place instead.
        """
        self.first = None
        self.last = None
        self.prev = None

        self.inorder(root)
        temp = self.first.val
        self.first.val = self.last.val
        self.last.val = temp

# time-O(n) space-O(1)