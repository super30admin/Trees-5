# // Time Complexity : O(n) where n is the number of nodes. 
# // Space Complexity : O(n) where n is the number of nodes.
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Class Solution.

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
        if root == None:
            return root
        queue = deque()
        # queue.append(root)
        if root.left != None:
            queue.append(root.left)
            queue.append(root.right) # perfect tree
        while(len(queue) != 0):
            size = len(queue)
            start = queue.popleft()
            if start.left != None:
                queue.append(start.left)
                queue.append(start.right)
            for i in range(1,size):
                node = queue.popleft()
                start.next = node
                start = node
                if node.left != None:
                    queue.append(node.left)
                    queue.append(node.right) # perfect tree
        return root
