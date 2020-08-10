#Time Complexity - O(h)
#Space Complexity - O(h)
"""
# Definition for a Node.
class Node(object):
    def __init__(self, val=0, left=None, right=None, next=None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""
from collections import deque
class Solution(object):
    def connect(self, root):
        """
        :type root: Node
        :rtype: Node
        """
        if not root:
            return root
        tmp = deque()
        tmp.append(root)
        t1 = root
        while tmp:
            l1 = len(tmp)
            prev = None
            for i in range(l1):
                curr = tmp.popleft()
                curr.next = None
                if not prev:
                    prev = curr
                    prev.next = None
                else:
                    prev.next = curr
                    prev = prev.next
                    prev.next=None
                
                if curr.left:
                    tmp.append(curr.left)
                if curr.right:
                    tmp.append(curr.right)
        return(root)