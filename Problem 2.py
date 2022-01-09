# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time: O(n)
# Space: O(1)
class Solution(object):
    def __init__(self):
        self.swapped = []
        self.prev = None
        self.flag = False
    def recoverTree(self, root):
        """
        :type root: TreeNode
        :rtype: None Do not return anything, modify root in-place instead.
        """
        self.helper(root)
        # swap
        temp = self.swapped[0].val
        self.swapped[0].val = self.swapped[1].val
        self.swapped[1].val = temp
    def helper(self, root):
        if root == None:
            return None
        if root.left != None:
            self.helper(root.left)
        if self.prev != None and self.prev.val >= root.val:
            if self.flag == False:
                self.swapped.append(self.prev)
                self.swapped.append(root)
                self.flag = True
            else:
                self.swapped[1] = root
        self.prev = root
        if root.right != None:
            self.helper(root.right)
        
        
            
        
