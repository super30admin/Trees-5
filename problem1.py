"""
# Definition for a Node.
class Node:
    def __init__(self, val, left, right, next):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""
class Solution:
    def connect(self, root: 'Node') -> 'Node':
        def helper(root):
            if not root:
                return
            if root.left:
                root.left.next=root.right
                if root.next:
                    root.right.next=root.next.left
            helper(root.left)
            helper(root.right)
        helper(root)
        return root