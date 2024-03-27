'''
TC: O(n) - where n is the number of nodes in the tree
SC: O(n) - total space taken ~ number of leaf nodes - O(n/2) ~ O(n)
Using queue and implementing BFS to make the connections
'''
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next

from collections import deque
from typing import Optional

class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        #BFS TC: O(n), SC: O(n)
        if not root:
            return
        q = deque()
        q.append(root)
        while q:
            l = len(q)
            while l>0:
                node=q.popleft()
                if l!=1:
                    node.next = q[0]
                if node.left:
                    q.append(node.left)
                    q.append(node.right)
                l-=1
        return root