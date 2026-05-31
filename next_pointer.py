class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next

class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if root is None:
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

# Time: O(n)
# Space: O(1)