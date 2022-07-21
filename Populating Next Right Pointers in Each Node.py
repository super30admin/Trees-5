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
        if (root == None):
            return root
        self.bfs(root)
        return root

    def bfs(self, root):
        # base
        if (root == None):
            return root

        q = deque()  # creating a queue
        q.append(root)
        while (q):
            previous = None
            size = len(q)
            for i in range(0, size):
                curr = q.popleft()
                if previous != None:
                    previous.next = curr
                previous = curr
                if (curr.left != None):
                    q.append(curr.left)
                if (curr.right != None):
                    q.append(curr.right)



