'''
Time Complexity: O(n) because we are only traversing the tree , here we are performing a level order traversal or BFS. 
Space Complexity: O(m) where m is the maximum number of nodes at any level of the tree, which is the space used by the queue.
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
    def connect(self, root: "Optional[Node]") -> "Optional[Node]":

        queue = deque()

        if root:
            queue.append(root)

        while queue:
            prevNode = None
            nextNode = None
            size = len(queue)
            while size > 0:
                node = queue.popleft()
                prevNode = nextNode
                nextNode = node
                if prevNode:
                    prevNode.next = nextNode
                size -= 1
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)

        return root


# ------------------   No Extra Space Approach       ----------------------#

"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

'''
Time Complexity: O(n) because we are only traversing the tree, here we are performing a level order traversal or BFS.
Space Complexity: O(1) because we are not using any extra space, we are modifying the tree in place.
'''

class Solution:
    def connect(self, root: "Optional[Node]") -> "Optional[Node]":

        def inorder(node):
            if not node:
                return

            if node and node.left and node.right:
                node.left.next = node.right
                if node.next is not None:
                    node.right.next = node.next.left
                else:
                    node.right.next = None
            inorder(node.left)
            inorder(node.right)

        inorder(root)

        return root

# ------------------   BFS Approach by connecting the next pointers       ----------------------#
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
    def connect(self, root: "Optional[Node]") -> "Optional[Node]":

        queue = deque()

        if root:
            queue.append(root)

        while queue:
            size = len(queue)
            while size > 0:
                node = queue.pop()
                if node.left:
                    node.left.next = node.right
                if node.right and node.next is not None:
                    node.right.next = node.next.left
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
                size -= 1

        return root
