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
Time Complexity --> O(n) since we are going through each node
Space Complexity --> O(n) for the queue
Using BFS approach
'''
class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if root==None:
            return None
        q = [root]
        
        while q:
            s = len(q)
            for i in range(s):
                node = q.pop(0)
                if i<s-1:
                    node.next = q[0]
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
        return root
        
        
        
            

