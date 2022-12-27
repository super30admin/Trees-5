"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

#TC: O(n)
#SC: O(1)

#Accepted on Leetcode

#Approach
#Use constant space by traversing level wise -> we use current's next to traverse level wise
#When traversing a given level -> set 'next' pointers for it's next level by using left and right values of current node (Can do this recursively or iteratively)

from collections import deque
class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if root == None:
            return None

        self.recurse(root.left, root.right)
        
        return root

    def recurse(self, left, right):
        if left == None:
            return

        left.next = right
        self.recurse(left.left, left.right)
        self.recurse(left.right, right.left)
        self.recurse(right.left, right.right)



                