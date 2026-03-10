# Time Complexity : O(n), n = number of nodes
# Space Complexity : O(h + n), h = height of tree (recursion stack), n = result list
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# 1. Perform a standard in-order traversal (left, root, right).
# 2. Append node values to the result list during traversal.
# 3. Return the result list containing nodes in in-order sequence.

from typing import List, Optional

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def inorderTraversal(self, root: Optional['TreeNode']) -> List[int]:
        result = []
        
        def inorder(node):
            if node:
                inorder(node.left)
                result.append(node.val)
                inorder(node.right)
        
        inorder(root)
        return result