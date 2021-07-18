# Time Complexity : O(n)
# Space Complexity : O(logn)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#keeping track of previous val to observe the data breach

class Solution:
    
    def __init__(self):
        self.prev = TreeNode(-99999999999999999)
        self.first = None
        self.last = None
        self.flag = False
    def recoverTree(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.inorder(root)
        temp = self.first.val
        self.first.val = self.last.val
        self.last.val = temp
        
        
    def inorder(self,root):
        if root == None:
            return;
        # if root.left != None:
        # self.prev = root.left
        self.inorder(root.left)
        if self.prev.val >= root.val:
            if self.flag == False:
                self.first = self.prev
                self.last = root
                self.flag = True
            else:
                self.last = root
        print(self.prev.val,root.val)
        self.prev= root
        self.inorder(root.right)
        
        
        