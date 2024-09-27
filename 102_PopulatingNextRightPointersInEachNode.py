'''
Accepted on leetcode(116)
Time - O(N), space - O(1)
Here, we have next pointer set to None for all nodes, we have to set next pointer to right node on same level.
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
    def connect(self, root: 'Node') -> 'Node':
        # Capture each levels by using level variable
        level = root
        # Traverse all levels one by one , as it is complete Binary Tree.
        while level != None:
            curr = level

            while curr != None:
                # if we have left node for sure we have right so connect left and right.
                if curr.left != None:
                    curr.left.next = curr.right
                # if we current element has right and also next then set curr.right.next = curr.next.left
                if curr.right != None and curr.next != None:
                    curr.right.next = curr.next.left
                curr = curr.next
            level = level.left
        return root