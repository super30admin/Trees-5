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
        """
        Approach:
        1. Use level-order traversal without extra space, starting from the root.
        2. For each level, connect the left child to the right child, and connect the right child to the next node's left child.
        3. Move to the next level by going to the leftmost node of the current level.

        Time Complexity: O(N), where N is the number of nodes — each node is visited once.
        Space Complexity: O(1), since the tree is modified in place and no extra data structures are used.
        """

        if not root:
            return None

        level = root

        while level.left:
            curr = level
            while curr:
                curr.left.next = curr.right
                if curr.next:
                    curr.right.next = curr.next.left
                curr = curr.next
            level = level.left

        return root
