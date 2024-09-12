# Time complexity : O(n) -- traversing all nodes
# Space complexity : O(1)
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

class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        # check for root is null
        if not root:
            return None
        
        # maintain the root as level for traversing
        level = root
        while level.left != None:
            # at each level, we maintain the curr as the root
            curr = level
            while curr != None:
                # point the left of the curr to the right
                curr.left.next = curr.right
                
                # if next current is not None, then place a pointer from right of curr to left of next
                if curr.next != None:
                    curr.right.next = curr.next.left
                
                # increment the curr in the same level
                curr = curr.next
            # after traversing all the nodes in a level, increment the level
            level = level.left
        
        # after doing modifications, we return root
        return root
