#  https://leetcode.com/problems/recover-binary-search-tree/

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
        if root == None:
            return
        self.first = None
        self.second = None
        self.prev = None
        self.inorder(root)
        temp = self.first.val
        self.first.val = self.second.val
        self.second.val = temp

    def inorder(self,root):
        # base
        if root == None:
            return 
        self.inorder(root.left)

        if self.prev != None and self.prev.val >= root.val:
            #breach
            # first
            if self.first == None:
                self.first = self.prev
                self.second = root
            else:
                self.second = root
        self.prev = root

        self.inorder(root.right)

# TC: O(n)
# SC: O(1) + rec stack space

# ----------------------------------------------------------------
# inorder traversal with two pointers to keep track of previous and current node. - iterative solution

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
        if root == None:
            return
        first = None
        second = None
        prev = None
        st = []

        while st or root != None:
            while root != None:
                st.append(root)
                root = root.left
            root = st.pop()
            if prev!= None and prev.val >= root.val:
                if first == None:
                    first = prev
                    second = root
                else:
                    second = root
            prev = root
            root = root.right

        first.val, second.val = second.val, first.val

# TC: O(n)
# SC: O(h) for stack space only