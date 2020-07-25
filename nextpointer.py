"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

# this problem can be solved by iterating over the tree
# STEPS: (breadth first traversal)
# keep a level pointer at the left most node on a level. 
# keep a current pointer which moves from leftmost node to the rightmost node on that level.
# navigate the left pointer till the end of the tree.
# Time complexity : O(n)
# Space complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no issues

class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if not root: return 
        level = root
        # breadth first search
        while level.left:
            curr = level
            # traverse at every level
            while curr:
                curr.left.next = curr.right
                if curr.next:
                    curr.right.next = curr.next.left
                curr = curr.next
            
            # keep traversing to the left most node until the end of the tree.
            level = level.left
        
        return root

# this problem can be solved by iterating over the tree
# STEPS:
# using a queue to navigate the tree.
# keep a note of the length of the array at each level.
# navigate the array at each level (by using the length of the array at each level) and add its children to the queue.
# Time complexity : O(n)
# Space complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no issues

from collections import deque

class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if not root: return
        lvlqueue = deque()
        lvlqueue.append(root)
        
        while lvlqueue:
            lvlsize = len(lvlqueue)
            prev = None
            for _ in range(lvlsize):
                curr = lvlqueue.popleft()
                if curr.left: # since it is a perfect binary tree, no need to check for right pointer
                    lvlqueue.append(curr.left)
                    lvlqueue.append(curr.right)
                if prev: 
                    prev.next = curr
                prev = curr
        
        return root
            
            