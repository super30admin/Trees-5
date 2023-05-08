# Time Complexity : O(n), where n is the number of nodes in the binary tree
# Space Complexity : O(1)
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next

class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if not root:
            return root
        
        level_start = root
        
        while level_start:
            curr = level_start
            
            while curr:
                if curr.left:
                    curr.left.next = curr.right
                    if curr.next:
                        curr.right.next = curr.next.left
                curr = curr.next
            
            level_start = level_start.left
        
        return root