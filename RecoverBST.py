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
        #Time Complexity : O(n)
        #Space Complexity : O(h)
        self.first = None
        self.second = None
        self.prev = None
        temp = self.first.val
        self.first.val = self.second.val
        self.second.val = temp
        return root
