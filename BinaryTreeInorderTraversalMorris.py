'''
TC: O(n) - Number of nodes in the tree amortized
            Worst case is O(h*n)
SC: O(1) - No  space taken. Just a couple of pointers curr and pre!
'''
# Definition for a binary tree node.
from typing import List, Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        res = []

        curr = root
        while(curr):
            if curr.left:
                pre = curr.left
                while pre.right and pre.right != curr:
                    pre = pre.right
                if pre.right:
                    pre.right = None
                    res.append(curr.val)
                    curr = curr.right
                else:
                    pre.right = curr
                    curr = curr.left
            else:
                res.append(curr.val)
                curr = curr.right

        return res