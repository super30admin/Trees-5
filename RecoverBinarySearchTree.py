from typing import Optional
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
# class Solution:
#     def recoverTree(self, root: Optional[TreeNode]) -> None:
#         """
#         Do not return anything, modify root in-place instead.
#         """
#         self.first = None
#         self.second = None
#         self.prev = None
#         def inorder(root):
#             # base
#             if not root : return None
#             # logic
#             inorder(root.left)
#             # root
#             if self.prev and self.prev.val >= root.val:
#                 if not self.first:
#                     self.first = self.prev
#                 self.second = root
#             self.prev = root
#             inorder(root.right)
#         inorder(root)
#         self.first.val ,self.second.val = self.second.val, self.first.val

# Definition for a binary tree node.
class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.first = None
        self.second = None
        self.prev = None
        def inorder(root):
            st = []
            while st or root:
                while root:
                    st.append(root)
                    root = root.left
                root = st.pop()
                if self.prev and self.prev.val >= root.val:
                    if not self.first:
                        self.first = self.prev
                    self.second = root
                self.prev = root
                root = root.right

            # inorder(root.left)
            # inorder(root.right)
        inorder(root)
        self.first.val ,self.second.val = self.second.val, self.first.val



        



        