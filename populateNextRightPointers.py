"""
TC - O(n)
SC - O(1)
"""
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
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if not root:
            return root

        # since started at root node
        # there are no next pointers
        leftmost = root

        # while leftmost.next exists
        while leftmost.left:

            head = leftmost

            while head:
                # establish connection one
                head.left.next = head.right

                # establish connection 2
                if head.next:
                    head.right.next = head.next.left

                # progress along the list
                head = head.next

            # move to next level
            leftmost = leftmost.left

        return root
