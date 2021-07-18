# Time Complexity : O(n)
# Space Complexity : O(logn)
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
#calculating on the go using the next pointers so as to avoid the queue
class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if root == None or root.left == None:
            return root
        
        curr = root
        nextHead = None
        
        while True:
            nextHead = curr.left
            
            if nextHead == None:
                return root
            while curr != None:
                curr.left.next = curr.right
                if curr.next != None:
                    curr.right.next = curr.next.left
                curr = curr.next
            
            curr = nextHead
            
        return root
        
            
            
            
        