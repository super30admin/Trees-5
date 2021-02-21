# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using recursion inorder traversal. Initialize flag to false and prev, first and last to None
# First we will recurse on root.left then check if prev is not Null and prev val >= root
# If flag is False then update first to prev and last to root for the first breach else if flag is True then update only last to root and return as we found the second breach
# If prev is Null assign prev to root and then recurse root.right
# Then we swap the first and last values after the recursion

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution:
    def recoverTree(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if not root:
            return None

        self.prev = self.first = self.last = None
        self.flag = False
        self.inorder(root)
        self.first.val, self.last.val = self.last.val, self.first.val

    def inorder(self, root):
        #base
        if not root:
            return
        #logic
        self.inorder(root.left)
        if self.prev and self.prev.val >= root.val:
            if self.flag == False:
                self.first = self.prev
                self.last = root
                self.flag = True
            else:
                self.last = root
                return

        self.prev = root
        self.inorder(root.right)