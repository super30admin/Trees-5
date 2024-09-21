"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""
# Time complexity - O(n)
# space complexity - O(1)
class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if not root:
            return root

        level = root # start from root to make connection between 2 and 3
        while level.left:
            curr = level
            while curr:
                curr.left.next = curr.right
                if (curr.next):
                    curr.right.next = curr.next.left
                curr = curr.next
            level = level.left
        return root
