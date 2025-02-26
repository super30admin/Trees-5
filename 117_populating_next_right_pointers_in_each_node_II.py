# Time complexity - O(n)
# Space complexity - O(1) # without maintaing queue

# Approach - Optimised - Still doing bfs, but this time maintaining a level variable and making connections
# between children of the curr node.

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
        if root is None:
            return root
        
        lvl = root
        while lvl.left != None:
            curr = lvl
            while curr != None:
                curr.left.next = curr.right
                if curr.next != None:
                    curr.right.next = curr.next.left
                curr = curr.next
            lvl = lvl.left
        return root