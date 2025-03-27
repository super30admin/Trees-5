"""
TC = O(n)
SC - O(n)
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
        if root is None: return None

        q = deque([])
        q.append(root)

        while q:
            qsize = len(q)
            curr = q.popleft()
            if curr.left is not None:
                q.append(curr.left)
                q.append(curr.right)

            for i in range(1, qsize):
                nextt = q.popleft()
                curr.next = nextt
                if nextt.left is not None:
                    q.append(nextt.left)
                    q.append(nextt.right)
                curr = nextt
        return root