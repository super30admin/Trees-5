# Time Complexity : O(N), number of nodes in the tree
# Space Complexity : O(H), height of the tree for the recursive stack
# The code ran on LeetCode

# Inorder Traversal. If root.left is not null, update its next pointer to root.right. If root.next is present, update root.right.next to root.next.left

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

        def dfs(root):
            if not root or not root.left:return
            root.left.next = root.right
            dfs(root.left)
            if root.next:
                root.right.next = root.next.left

            dfs(root.right)

        dfs(root)
        return root