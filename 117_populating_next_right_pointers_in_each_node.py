# Time complexity - O(n)
# Space complexity - O(n)

# Approach - Simple level order traversal, only update prev.next to curr if prev is not None.

from typing import Optional
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next

from queue import Queue
class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if root == None:
            return root
        
        q = Queue()
        q.put(root)

        while not q.empty():
            size = q.qsize()
            prev = None
            for i in range(size):
                curr = q.get()
                if prev:
                    prev.next = curr
                prev = curr
                if curr.left:
                    q.put(curr.left)
                if curr.right:
                    q.put(curr.right)
        return root