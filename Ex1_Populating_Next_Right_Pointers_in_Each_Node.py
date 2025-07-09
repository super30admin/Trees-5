# ----------------------------------------------------
# Intuition:
#
# Goal: Connect each node's `next` pointer to its right neighbor in a perfect binary tree.
#
# Optimal Iterative Level Traversal (O(1) space):
#    - Traverse level by level using `next` pointers.
#    - For each node at a level:
#        - Connect node.left → node.right
#        - Connect node.right → node.next.left (if node.next exists)
#    → Time: O(n), Space: O(1)
#
# Alternative DFS Preorder:
#    - Recursively traverse in preorder.
#    - For each node, connect node.left → node.right and node.right → node.next.left.
#    → Time: O(n), Space: O(h)
#
# BFS with Queue:
#    - Use level-order traversal and a queue.
#    - Connect each node in the level to its right neighbor.
#    → Time: O(n), Space: O(n)
# ----------------------------------------------------

from typing import Optional

class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next

class Solution:
    # ----------------------------------------------------
    # Iterative Level Traversal (Optimal, O(1) space)
    # ----------------------------------------------------
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if not root:
            return None

        leftmost = root

        while leftmost.left:
            head = leftmost
            while head:
                head.left.next = head.right
                if head.next:
                    head.right.next = head.next.left
                head = head.next
            leftmost = leftmost.left

        return root

    # ----------------------------------------------------
    #  DFS Recursive Preorder (Alternative)
    # ----------------------------------------------------
    # def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
    #     if not root:
    #         return None
    #
    #     def preorder(node):
    #         if not node or not node.left or not node.right:
    #             return
    #         node.left.next = node.right
    #         if node.next:
    #             node.right.next = node.next.left
    #         preorder(node.left)
    #         preorder(node.right)
    #
    #     preorder(root)
    #     return root

    # ----------------------------------------------------
    #  BFS using Queue (Alternative)
    # ----------------------------------------------------
    # from collections import deque
    # def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
    #     if not root:
    #         return None
    #     q = deque([root])
    #     while q:
    #         size = len(q)
    #         for i in range(size):
    #             node = q.popleft()
    #             if i < size - 1:
    #                 node.next = q[0]
    #             if node.left:
    #                 q.append(node.left)
    #             if node.right:
    #                 q.append(node.right)
    #     return root
