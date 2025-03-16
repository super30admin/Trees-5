"""
# Definition for a Node.
class Node(object):
    def __init__(self, val=0, left=None, right=None, next=None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""
import collections

# Level Order BFS
# TC : O(N)
# SC : O(N/2) - for number of elements in the queue
class Solution(object):
    def connect(self, root):
        """
        :type root: Node
        :rtype: Node
        """
        if root is None:
            return

        queue = collections.deque()
        queue.append(root)
        # print(queue[0].val)

        while queue:
            size = len(queue)
            for i in range(0,size):
                node = queue.popleft()
                if i != size-1:
                    node.next = queue[0]
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)

        return root

# Optimized BFS
# TC : O(N)
# SC : O(1)
class Solution(object):
    def connect(self, root):
        """
        :type root: Node
        :rtype: Node
        """
        if root is None:
            return

        level = root

        while level.left:
            current = level
            while current:
                current.left.next = current.right
                if current.next:
                    current.right.next = current.next.left
                current = current.next
            level = level.left
        return root


# DFS with two roots
# TC : O(N)
# SC : O(H) - H is height of the tree
class Solution(object):
    def connect(self, root):
        """
        :type root: Node
        :rtype: Node
        """
        if root is None:
            return

        self.helper(root.left,root.right)
        return root

    def helper(self,left,right):

        if left is None:
            return

        left.next = right
        self.helper(left.left, left.right)
        self.helper(left.right, right.left)
        self.helper(right.left, right.right)


# Optimized DFS
# TC : O(N)
# SC : O(H) - H is height of the tree
class Solution(object):
    def connect(self, root):
        """
        :type root: Node
        :rtype: Node
        """
        if root is None:
            return

        self.helper(root)
        return root

    def helper(self,node):
        if node.left is None:
            return

        node.left.next = node.right
        if node.next:
            node.right.next = node.next.left
        self.helper(node.left)
        self.helper(node.right)









