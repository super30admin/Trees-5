# Time Complexity : O(n), n = number of nodes
# Space Complexity : O(1), uses next pointers only (no extra data structures)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# 1. Connect each node's next pointer to its right neighbor at the same level.
# 2. Use a level-by-level traversal without extra space.
# 3. For each level, connect children nodes using the next pointers of parent nodes.

from typing import Optional

# Definition for a Node.
# class Node:
#     def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
#         self.val = val
#         self.left = left
#         self.right = right
#         self.next = next

class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if not root:
            return None
        
        leftmost = root
        
        while leftmost.left:
            head = leftmost
            while head:
                # Connect left child to right child
                head.left.next = head.right
                # Connect right child to next node's left child if exists
                if head.next:
                    head.right.next = head.next.left
                head = head.next
            leftmost = leftmost.left
        
        return root