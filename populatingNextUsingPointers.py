"""
Time Complexity: O(N)
Space Complexity: O(1)
Compiled on Leetcode?: Yes
"""
class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if not root:
            return None
        parent = root
        while parent.left:
            left = parent.left
            while parent:
                child = parent.left
                child.next = parent.right
                if parent.next:
                    parent.right.next = parent.next.left
                parent = parent.next
            parent = left
        return root  