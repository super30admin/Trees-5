# Time Complexity :O(N)
# Space Complexity :O(N)
# Did this code successfully run on Leetcode :yes


# Definition for a Node.
from collections import deque
from typing import Optional


class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next


class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if not root:
            return None

        q = deque()
        q.append(root)

        while q:
            level_size = len(q)
            for i in range(level_size):
                curr = q.popleft()
                if i < level_size - 1:
                    curr.next = q[0]

                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)

        return root
        
        