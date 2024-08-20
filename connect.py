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
    '''
    Time Complexity: O(N), where N is the number of nodes in the tree
    Space Complexity: O(1)
    '''
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        # Initialize curr to root and nxt to the left child of root, if root is not None
        curr, nxt = root, root.left if root else None
        
        # Continue the loop as long as both curr and nxt are not None
        while curr and nxt:
            # Connect the left child's next pointer to the right child
            curr.left.next = curr.right
            
            # If curr has a next pointer, connect the right child's next pointer to curr's next left child
            if curr.next:
                curr.right.next = curr.next.left
            
            # Move curr to the next node at the same level
            curr = curr.next
            
            # If curr becomes None, we have finished processing the current level
            # Move curr to the start of the next level (nxt) and update nxt to the left child of curr
            if not curr:
                curr = nxt
                nxt = curr.left
        
        # Return the modified tree with all next pointers correctly assigned
        return root
