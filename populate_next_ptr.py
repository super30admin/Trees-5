"""
Approach1: BFS with extra space, TC: O(log n), SC: O(n)
Todo: using dfs, bfs w/o extra space,
"""
from collections import deque
class Solution:
    def bfs(self, root):
        q = deque()
        q.append(root)
        while q:
            size = len(q)
            for i in range(size):
                curr = q.popleft()

                if i != size - 1:
                    curr.next = q[0]

                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)

    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if not root:
            return root
        self.bfs(root)
        return root