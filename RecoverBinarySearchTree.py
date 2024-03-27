'''
TC: O(n) - total number of nodes in a tree
SC: O(h) - height of the tree
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        #DFS
        self.left, self.right = None, None
        self.prev = None

        def dfs(root):
            if not root:
                return
            dfs(root.left)
            if self.prev and self.prev.val>root.val:
                if not self.left:
                    self.left = self.prev
                    self.right = root
                else:
                    self.right = root
            self.prev = root
            dfs(root.right)
        dfs(root)
        if self.left and self.right:
            self.left.val,self.right.val = self.right.val,self.left.val