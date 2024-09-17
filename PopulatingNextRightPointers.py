# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# BruteForce approach is BFS level order traversal to get each level and point the next nodes at each level. But this approach uses space as we have to store each node in queue.
# To optimize this we can traverse through each level and for each current node in that level until current node we will point the pointer of current left child to its right child
# And current right child is pointed to current.next left child if there is next node of current and increment the level to level.left
# We will do this until the level.left becomes null
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
            return None
        level = root
        while level.left:
            current = level
            while current:
                current.left.next = current.right
                if current.next:
                    current.right.next = current.next.left
                current = current.next
            level = level.left
        return root