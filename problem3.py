# Time Complexity :O(N)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode :yes

# Definition for a binary tree node.
class TreeNode:
     def __init__(self, val=0, left=None, right=None):
         self.val = val
         self.left = left
         self.right = right
from ast import List
from typing import Optional


class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        inorder = []
        curr = root

        while curr:
            if curr.left is None:
                inorder.append(curr.val)
                curr = curr.right
            else:
                pre = curr.left
                while pre.right and pre.right != curr:
                    pre = pre.right
                
                if pre.right is None:
                    pre.right = curr
                    curr = curr.left
                else:
                    pre.right = None
                    inorder.append(curr.val)
                    curr = curr.right
        
        return inorder

        