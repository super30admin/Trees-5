"""
// Time Complexity : O(n), 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
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
            return
        level = root #keep tracks of the level
    
        while level.left:
            cur = level #keeps track of nodes at that level
            while cur:
                cur.left.next = cur.right #creating link bw left and right child
                if cur.next:
                    cur.right.next = cur.next.left #creating link bw the right child of current and left child of next
                cur = cur.next #move to next node in the same level
            level = level.left #move to next level
            
        return root
                