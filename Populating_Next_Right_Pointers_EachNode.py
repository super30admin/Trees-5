# Approach:
# The problem can be solved using a level-by-level traversal.
# For each level, connect the left and right children of the current node.
# Also, connect the right child of the current node to the left child of its next sibling.
# A perfect binary tree ensures that we can use this approach without additional space.

# Time Complexity: O(n), where n is the number of nodes in the tree, as each node is visited once.
# Space Complexity: O(1), as no extra space is used other than variables.
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

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
        if not root:
            return None
        
        # Start with the leftmost node of the tree (root initially)
        leftmost = root
        
        while leftmost.left:  # While there are more levels to process
            # Iterate through the nodes at the current level
            head = leftmost
            while head:
                # Connect the left child to the right child
                head.left.next = head.right
                
                # Connect the right child to the left child of the next node (if exists)
                if head.next:
                    head.right.next = head.next.left
                
                # Move to the next node in the current level
                head = head.next
            
            # Move to the next level
            leftmost = leftmost.left
        
        return root
