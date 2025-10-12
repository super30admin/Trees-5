# Time Complexity : O(n) where n is the number of nodes in the binary tree
# Space Complexity : O(1) where h is the height of the binary tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach:
# I am using level order traversal to traverse the binary tree. I will keep track of the current level and its nodes.
# I am connecting this to form a linked list using the next pointer.
#I will connect the left child to the right child and the right child to the next node's left child.
# I will continue this process until I reach the last level of the binary tree.
# I will return the root of the binary tree.


from typing import Optional
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next


class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if not root:
            return None
        level = root
        while level.left:
            curr = level
            while curr:
                curr.left.next = curr.right
                if curr.next:
                    curr.right.next = curr.next.left
                curr = curr.next
            level = level.left
        return root
