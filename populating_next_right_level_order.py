# Time Complexity : O(N) whenre N is number of Nodes in the tree
# Space Complexity : O(N) whenre N is number of Nodes in the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

from collections import deque

class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if root == None:
            return None
        q = deque()
        q.appendleft(root)
        
        
        while len(q) > 0:
            size = len(q)
            prev = None
            for _ in range(size):
                curr = q.pop()
                if prev != None:
                    prev.next = curr
                
                prev = curr
                if curr.left != None:
                    q.appendleft(curr.left)
                if curr.right != None:
                    q.appendleft(curr.right)
                    
        
        return root