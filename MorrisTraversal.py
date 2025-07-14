from typing import Optional, List
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        curr = root
        res = []
        while curr:
            if not curr.left:
                res.append(curr.val)
                curr = curr.right
            else:
                prev = curr.left
                while prev.right and prev.right!=curr:
                    prev = prev.right
                if not prev.right:
                    prev.right = curr
                    curr = curr.left
                else :
                    prev.right = None
                    res.append(curr.val)
                    curr=curr.right
        return res

        