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



        self.first, self.second, self.prev = None, None, None



        def dfs(node):

            if not node:

                return



            dfs(node.left)



            if self.prev and node.val < self.prev.val:

                if not self.first:

                    self.first = self.prev

                    self.second = node

                elif self.second:

                    self.second = node

            else:

                self.prev = node



            dfs(node.right)

        dfs(root)



        self.first.val, self.second.val = self.second.val, self.first.val

