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
    def connect(self, root: "Optional[Node]") -> "Optional[Node]":
        if not root:
            return None
        level = root

        while level.left is not None:
            curr = level
            while curr is not None:
                curr.left.next = curr.right
                if curr.next is not None:
                    curr.right.next = curr.next.left

                curr = curr.next
            level = level.left
        return root


# time complexity is O(n)
# space complexity is O(1)
