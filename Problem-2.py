#Approach
#Do the inorder traveral if the root is greater than the current then that is violation and save the two violations and swap the violations



#Complexities
#Time : O(n)
#Space: O(n)




# Definition for a binary tree node.
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.first, self.second = None, None
        self.prev = None
        self.helper(root)
        self.first.val, self.second.val = self.second.val, self.first.val

    def helper(self, root):
        if root == None:
            return
        if root.left:
            self.helper(root.left)
        if self.prev is not None and self.prev.val >= root.val:
            if not self.first:
                self.first = self.prev
                self.second = root
            else:
                self.second = root

        self.prev = root
        if root.right:
            self.helper(root.right)

