from collections import deque

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
    """
    Approach 1: BFS
    1) At each level, point the next pointer to the node towards the right of the current node
        a) these would automatically be in the required order on the q
    2) last node in the q is already pointing to null

    TC: O(n)
    SC: O(n/2) Breadth of the tree
    """

    def connect(self, root: 'Node') -> 'Node':
        if not root:
            return root
        q = deque()
        q.append(root)
        while q:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                if curr.left:  # since its a complete tree, if there is a left node, there would be a right node too, so no check is needed
                    q.append(curr.left)
                    q.append(curr.right)
                if i != size - 1:
                    curr.next = q[0]
        return root

    """
    Approach 2: Itertive
    1) at each node, create the connection between left and right
    2) at each level, traverse from left to right using the connection created in previous step
    3) Also make sure to create the connect between cousins

    TC: O(n)
    SC: O(1)
    """

    def connect(self, root: 'Node') -> 'Node':
        if not root:
            return root
        level = root
        while level:  # iterate through levels
            curr = level
            next_level = curr.left  # could have also updated the levels here directly
            while curr:  # at each level, iterate through nodes
                if curr.left:
                    curr.left.next = curr.right
                    if curr.next:  # the last level will not have left node, so we do this via a nested if condition
                        curr.right.next = curr.next.left
                curr = curr.next  # update nodes
            level = next_level  # update levels
        return root

    # approach 3: DFS
    """
    TC: O(n)
    SC: O(h) # height of the tree
    """

    def connect(self, root: 'Node') -> 'Node':
        if not root:
            return root
        self.dfs(root.left, root.right)
        return root

    def dfs(self, left, right):
        # base
        if not left:  # if not a complete binary tree "if not left or not right: return"
            return
        # logic
        left.next = right
        self.dfs(left.left, left.right)
        self.dfs(right.left, right.right)
        self.dfs(left.right, right.left)