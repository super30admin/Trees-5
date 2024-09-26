"""
Time Complexity : O(n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this: none
"""

"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""
class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if not root:
            return root
        
        temp = root
        curr = root
        while curr.left:
            curr.left.next = curr.right
            
            if curr.next and curr.next.left:
                curr.right.next = curr.next.left
            
            if curr.next:
                curr = curr.next
            else:
                temp = temp.left
                curr = temp
                
        return root
        