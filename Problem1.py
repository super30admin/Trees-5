'''
1. We need to set at each level the nodes next node as the same level node existing on its right.
2. At a parent node if there is a right child, we set the next of left child as the right child. If there is no right child, it is default set to None anyways.
3. Repeat this process until its the last parent node. Since the tree is modified in place, we return the root.

TC: O(N)
SC: O(1)
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
        if not root:
            return root
        
        left = root
        cur = None

        while left.left != None:
            cur = left
            while cur != None:
                cur.left.next = cur.right
                if cur.next:
                    cur.right.next = cur.next.left
                cur = cur.next
            left = left.left
        return root