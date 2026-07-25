
## Problem1 Populating Next Right Pointers in Each Node(https://leetcode.com/problems/populating-next-right-pointers-in-each-node/)
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
        """
        Time Complexity: O(N) 
        - We visit each node in the tree exactly once to establish the next pointers 
          for its children. N is the total number of nodes.
          
        Space Complexity: O(1) 
        - We only use a couple of pointers (`level` and `curr`) to traverse the tree. 
        - We avoid using a queue (which would take O(N) space) by leveraging the `next` 
          pointers we establish on the current level to traverse the next level.
        """
        if not root:
            return None
        
        # 'level' points to the leftmost node of the current level we are processing.
        level = root
        
        # Since it's a perfect binary tree, if a node has a left child, it has a right child.
        # We loop until we reach the last level (which won't have a left child).
        while level.left:
            # 'curr' is used to traverse across the current level horizontally using 'next' pointers.
            curr = level
            
            while curr:
                # Connection 1: Connect the left child to the right child of the SAME parent.
                curr.left.next = curr.right
                
                # Connection 2: Connect the right child to the left child of the NEXT parent.
                # If curr.next exists, it means there is an adjacent subtree to the right.
                if curr.next:
                    curr.right.next = curr.next.left
                
                # Move to the next node on the current level
                curr = curr.next
            
            # Move down to the next level by going to the leftmost child
            level = level.left
            
        return root