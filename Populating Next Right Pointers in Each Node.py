# Time complexity: O(n)
# Space complexity: O(1)
# Approach: have level and curr pointers
# level always travels from first level to last level only with left mmost node
# while level and level.left exists:
# make curr point to level and while curr exists,
# curr's left's next should be set to curr's right
# and while curr's next is not none,curr's right's next should point to curr's next's left
# move curr to curr.next
# after when curr becomes null, move level to level.left
# This way, since we have next pointer that connect to the next child, no need to use a queue
# Hence constant space.



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
        level = root
        curr = None
        while level is not None and level.left is not None:
            curr = level
            while(curr !=  None):
                curr.left.next = curr.right
                if curr.next != None:
                    curr.right.next = curr.next.left
                    
                curr = curr.next
            level = level.left
        return root
                
        