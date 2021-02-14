# -*- coding: utf-8 -*-
"""
TC: O(N) where N is the nodes in a tree
SC: O(max breadth of a tree) = O(N/2)
"""
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next

import collections

class Solution:
    def connect(self, root: 'Node') -> 'Node':
        queue = collections.deque()
        if not root:return
        queue.append(root)
        while queue: 
            d = None
            for i in range(len(queue)):                
                c = queue.pop() 
                c.next = d
                d = c
                if c.right is not None: queue.appendleft(c.right)
                if c.left is not None: queue.appendleft(c.left)
        return root

S = Solution()
print(S.connect([1,2,3,4,5,6,7]))