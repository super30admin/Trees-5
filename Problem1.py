# Time Complexity = O(n) Space Complexity = O(1)

from typing import Optional
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next


class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        self.helper(root, None)
        return root

    def helper(self, root: 'Node', parent: 'Node') -> None:
        if root is None:
            return
        if parent is not None:
            parent.left.next = parent.right
        if parent is not None and parent.next is not None:
            parent.right.next = parent.next.left
        if root.left is None and root.right is None:
            return
        self.helper(root.left, root)
        self.helper(root.right, root)