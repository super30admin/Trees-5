'''
T =O(n)
S = O(n)

Approach:
BFS and obtain the level order traversal and at each level make the next pointer to its right
'''

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
    def connect(self, root: 'Node') -> 'Node':
        if not root:
            return
        
        Q = deque()
        Q.append(root)
        
        while len(Q) > 0:
            size = len(Q)
            for i in range(size):
                Node = Q.popleft()
                if Node.left != None:
                    Q.append(Node.left)
                if Node.right != None:
                    Q.append(Node.right)
                    
                if i == size - 1:
                    Node.next = None
                else:
                    Node.next = Q[0]
        return root

'''
T = O(n)
S = O(1)

Approach:
Instead of using a queue in the BFS approach we can directly create the next pointer at the time of
traversal this makes the space to be constant. 
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

        if root == None: return

        level = root
        while level.left:
            curr = level
            while curr:
                curr.left.next = curr.right
                if curr.next != None:
                    curr.right.next = curr.next.left
                curr = curr.next
            level = level.left
        return root
            