# Time complexity - O(n)
# Space complexity - O(h)

# Approach - Simple inorder traversal using DFS

from typing import Optional, List
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        if root is None:
            return []
        self.res = []
        self.dfs(root)
        return self.res
    
    def dfs(self, root: Optional[TreeNode]) -> None:
        if root == None:
            return
        
        self.dfs(root.left)
        self.res.append(root.val)
        self.dfs(root.right)