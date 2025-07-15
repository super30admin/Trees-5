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
            return None

        q = deque([root])

        while q:
            size = len(q)
            for i in range(size):
                node = q.popleft()
                
                # Connect to next node in queue if not the last node of this level
                if i < size - 1:
                    node.next = q[0]
                #perfect complete tree one baby is there another one will be there 
                if node.left:
                    q.append(node.left)
                    q.append(node.right)

        return root

