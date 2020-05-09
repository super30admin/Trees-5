"""
// Time Complexity : O(n) 
// Space Complexity : O(1)  //height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
Algorithm explanation
Method 1- BFS with updating next pointer for current root using two pointer (prev, curr)
mechanism

Set prev to None at the start of each level
curr = queue.poll()
if prev is not None
    prev.next = curr
curr.next = None
prev = curr
""" 
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
from collections import deque
class Solution:
    def connect(self, main: 'Node') -> 'Node':
        result = []
        q = deque([main])
        while q:
            size = len(q)
            prev = None
            for _ in range(size):
                root = q.popleft()
                #curr = root
                #updating the next pointer
                if prev:
                    prev.next = root
                root.next = None
                prev = root
                
                if root.left:
                    q.append(root.left)
                if root.right:
                    q.append(root.right)
        return main