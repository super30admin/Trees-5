""""// Time Complexity : O(n)
// Space Complexity : O(h)- Recursive stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Recursion
class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.prev=None
        self.first=None
        self.second=None
        if root==None:
            return root
        self.inorder(root)

        self.first.val, self.second.val= self.second.val, self.first.val

    def inorder(self, root):
        #base
        if root==None:
            return


        #logic
        self.inorder(root.left)

        if self.prev!=None and self.prev.val>=root.val:
            if self.first==None:
                self.first=self.prev
                self.second=root
            else:
                self.second=root
        self.prev=root


        self.inorder(root.right)




# Iterative
# class Solution:
#     def recoverTree(self, root: Optional[TreeNode]) -> None:
#         """
#         Do not return anything, modify root in-place instead.
#         """
#         self.prev = None
#         self.first = None
#         self.second = None
#         if root == None:
#             return root
#         self.inorder(root)
#
#         self.first.val, self.second.val = self.second.val, self.first.val
#
#     def inorder(self, root):
#         stack = []
#
#         while stack or root:
#             while root:
#                 stack.append(root)
#                 root = root.left
#             root = stack.pop()
#             if self.prev != None and self.prev.val >= root.val:
#                 if self.first == None:
#                     self.first = self.prev
#                     self.second = root
#                 else:
#                     self.second = root
#             self.prev = root
#             root = root.right










