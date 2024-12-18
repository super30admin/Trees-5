# The inorderTraversal method performs an in-order traversal of a binary tree.

# Use a helper method (inorder) for recursive traversal:
# - Traverse the left subtree.
# - Append the current node's value to the result list.
# - Traverse the right subtree.

# The result list stores the values in in-order sequence.

# TC: O(n) - Each node is visited once.
# SC: O(h) - Space for the recursion stack, where h is the tree height.


# Definition for a binary tree node.
from typing import List, Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        self.inorder(root, result)
        return result
    
    def inorder(self, node: Optional[TreeNode], result: List[int]) -> None:
        if not node:
            return
        self.inorder(node.left, result)
        result.append(node.val)
        self.inorder(node.right, result)