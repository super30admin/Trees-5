'''
Problem2 Recover Binary Search Tree(https://leetcode.com/problems/recover-binary-search-tree/)
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None: # type: ignore
        """
        Do not return anything, modify root in-place instead.
        """
        if root == None:
            return

        self.prev = None
        self.first = None
        self.second = None
        self.dfs(root)
        #swap
        temp = self.first.val
        self.first.val = self.second.val
        self.second.val = temp

    def dfs(self, root:Optional[TreeNode]) -> None: # type: ignore
        if root == None:
            return
        self.dfs(root.left)
        if self.prev != None and self.prev.val > root.val:
            #first breach
            if self.first == None:
                self.first = self.prev
            self.second = root
        self.prev = root    

        self.dfs(root.right)                