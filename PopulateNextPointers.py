class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
# Level order traversal
# TC: O(n)
# SC: O(n) n/2
from collections import deque
class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if root == None: return None
        q = deque()
        q.append(root)
        while q:
            size = len(q)
            prev = q.popleft()
            if prev.left: q.append(prev.left)
            if prev.right: q.append(prev.right)
            for i in range(1, size):
                curr = q.popleft()
                if curr.left: q.append(curr.left)
                if curr.right: q.append(curr.right)
                prev.next = curr
                prev = curr
        return root

# O(1) space 

class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if root == None: return None
        level = root
        while level.left:
            curr = level
            while curr:
                curr.left.next = curr.right
                if curr.next: curr.right.next = curr.next.left
                curr = curr.next
            level = level.left
        return root

# DFS
class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if root == None: return None
        self.helper(root.left, root.right)
        return root
    
    def helper(self, left, right):
        # base
        if left == None: return
        # logic
        left.next = right
        self.helper(left.left, left.right)
        self.helper(left.right, right.left)