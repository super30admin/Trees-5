# Time complexity : O(n) -- traversing all nodes
# Space complexity : O(n) --> queue
# Leetcode : Solved and submitted

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
        # check for root is null
        if not root:
            return None
        
        # insert root to queue
        q = deque([root])
        while q:
            # for each level prev is set to None
            prev = None
            # traversing nodes at each level
            for i in range(len(q)):
                # for curr node
                curr = q.popleft()
                # check if curr is not null and prev is not None
                if curr != None and prev != None:
                    # we point the left node to the one in the right
                    prev.next = curr
                # move the prev pointer
                prev = curr
                
                # add children of the current node to queue
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
                    
                #curr = curr.next
        return root
