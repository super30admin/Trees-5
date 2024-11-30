# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def recoverTree(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: None Do not return anything, modify root in-place instead.
        """
        self.prev = None
        self.first = None
        self.second = None
        #self.helper(root)
        stack = []
        current = root
        while(current or stack):
            while(current):
                stack.append(current)
                current = current.left
            current = stack.pop()
            if(self.prev and self.prev.val >= current.val):
                if(self.first == None):
                    self.first = self.prev
                    self.second = current
                else:
                    self.second = current

            self.prev = current
            current = current.right
        temp = self.first.val
        self.first.val = self.second.val
        self.second.val = temp



    # def helper(self,root):

    #     if(root == None):
    #         return
    #     self.helper(root.left)
    #     if(self.prev and self.prev.val >= root.val):
    #         if(self.first == None):
    #             self.first = self.prev
    #             self.second = root
    #         else:
    #             self.second = root
    #     self.prev = root
    #     self.helper(root.right)
        