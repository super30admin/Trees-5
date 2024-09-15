"""
# Definition for a Node.
class Node(object):
    def __init__(self, val=0, left=None, right=None, next=None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

# TC - O(n)
# SC - O(n) for queue and constant for pointers soln


class Solution(object):
    def connect(self, root):
        """
        :type root: Node
        :rtype: Node
        """
        if not root:
            return None

        def dfs():
            queue = deque([root])

            while queue:

                size = len(queue)

                for i in range(size):

                    node = queue.popleft()

                    if i < size - 1:
                        node.next = queue[0]

                    if node.left:
                        queue.append(node.left)

                    if node.right:
                        queue.append(node.right)

        def ptr():
            leftmost = root
            current = root

            while(leftmost.left):

                while(current):

                    current.left.next = current.right

                    if current.next:
                        current.right.next = current.next.left

                    current = current.next

                leftmost = leftmost.left
                current = leftmost

        ptr()
        return root
