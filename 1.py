'''
Trees-5

Problem1 Populating Next Right Pointers in Each Node(https://leetcode.com/problems/populating-next-right-pointers-in-each-node/)
'''

"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""
from queue import Queue

class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]': # type: ignore
        if root == None:
            return

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
        