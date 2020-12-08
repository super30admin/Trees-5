"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

"""
Time complexity O(N)
Space complexity O(N)
"""

class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if root is None:
            return None 
        q=[]
        q.append(root)
        while q:
            size=len(q)
            for i in range(size):
                curr=q.pop(0)
                if (i != size-1):
                    curr.next=q[0]
                if(curr.left):
                    q.append(curr.left)
                    q.append(curr.right)
        return root