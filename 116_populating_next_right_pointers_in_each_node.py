# Leetcode: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

# Approach 1: BFS Level Order Traversal
# Time Complexity: O(N) since we process each node exactly once. Note that processing a node
#   in this context means popping the node from the queue and then establishing the next pointers.
# Space Complexity: O(N). This is a perfect binary tree which means the last level contains N/2 nodes.
#   The space complexity for breadth first traversal is the space occupied by the queue which is
#   dependent upon the maximum number of nodes in particular level. So, in this case, the space
#   complexity would be O(N).

import collections

# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next

class Solution:
    def connect(self, root: 'Node') -> 'Node':

        if not root:
            return root

        # Initialize a queue data structure which contains
        # just the root of the tree
        Q = collections.deque([root])

        # Outer while loop which iterates over
        # each level
        while Q:

            # Note the size of the queue
            size = len(Q)

            # Iterate over all the nodes on the current level
            for i in range(size):

                # Pop a node from the front of the queue
                node = Q.popleft()

                # This check is important. We don't want to
                # establish any wrong connections. The queue will
                # contain nodes from 2 levels at most at any
                # point in time. This check ensures we only
                # don't establish next pointers beyond the end
                # of a level
                if i < size - 1:
                    node.next = Q[0]

                # Add the children, if any, to the back of
                # the queue
                if node.left:
                    Q.append(node.left)
                if node.right:
                    Q.append(node.right)

        # Since the tree has now been modified, return the root node
        return root


# Approach 2: Using previously established next pointers
# Time Complexity: O(N) since we process each node exactly once.
# Space Complexity: O(1) since we don't make use of any additional data structure for traversing nodes on a particular level like the previous approach does.


class Solution:
    def connect(self, root: 'Node') -> 'Node':
        # base case
        if not root:
            return root

        # start with the root node
        leftmost = root

        # iterate till final level
        while leftmost.left:
            # Iterate the linked list starting from the head node and
            # using the next pointers, establish the corresponding links for the next level
            head = leftmost
            while head:
                # connection 1
                head.left.next = head.right

                # connection 2
                if head.next:
                    head.right.next = head.next.left

                # progress along the list (nodes on the current level)
                head = head.next

            # move onto the next level
            leftmost = leftmost.left

        return root