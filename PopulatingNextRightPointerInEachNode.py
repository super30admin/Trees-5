"""
Time Complexity : O(n) where n is the number of nodes in the perfect Binary Tree
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
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
from collections import deque
class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if not root:
            return root
        level = root
        # Travel level order and initialize the next pointers level wise iterative
        # Eg: 1
        #    /  \
        #   2 -->3  1st and then we should move from 2->5->next = 3->6 after doing
        #  / \  / \                                          1->left->next = 1->right
        # 4   5 6  7
        while level.left:
            curr = level
            while curr:
                curr.left.next = curr.right
                if curr.next != None:
                    curr.right.next = curr.next.left
                curr = curr.next
            level = level.left
        return root