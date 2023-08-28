'''
Problem:  Populating Next Right Pointers in Each Node
Time Complexity: O(n), where n is given nodes
Space Complexity: O(1)
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
       start with each level
       at each level initialise curr pointer
       curr will traverse through each node at a level
       while traversing keep joining the nodes
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

class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        
        if root is None:
            return

        level = root

        while level.left:
            curr = level
            while curr:
                curr.left.next = curr.right
                if curr.next != None:
                    curr.right.next = curr.next.left
                curr = curr.next
            level = level.left
            
        return root
        