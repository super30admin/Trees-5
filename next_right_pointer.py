# Time Complexity: O(n) where n is the number of nodes
# Space Complexity: O(h) where h is the height of tree
# Ran on Leetcode: Yes

"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if not root:
            return root
        left = root.left
        right = root.right
        self.dfs(left, right)
        return root
    
    def dfs(self, left, right):
        if not left:
            return
        left.next = right
        self.dfs(left.left, left.right)
        self.dfs(left.right, right.left)
        self.dfs(right.left, right.right)
        return