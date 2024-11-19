#Approach
#left root right traversal


#Complexities
#Time: O(n)
#Space: O(n)

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
from typing import Optional, List


class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        self.result = []

        if root:
            self.helper(root)
        return self.result

    def helper(self, root):

        if root.left:
            self.helper(root.left)

        self.result.append(root.val)

        if root.right:
            self.helper(root.right)