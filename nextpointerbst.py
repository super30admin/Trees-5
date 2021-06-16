"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""
# TC:- O(n)
# Spac:- O(1)

class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if root is None: return None
        level = root
        while level.left is not None:
            current = level
            while current is not None:
                current.left.next = current.right
                if current.next is not None:
                    current.right.next = current.next.left
                current = current.next

            level = level.left

        return root
