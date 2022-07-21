
"""
M1- BFS and use a queue to establish a connection between the nodes at one level
TC = O(n)
SC = O(n)

"""

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
        if root is None:
            return None
        q = deque()
        q.append(root)
        prev = None
        
        while (len(q)!=0):
            size = len(q)
            
            for i in range(size):
                curr = q.popleft()
                if i!=0:
                    prev.next = curr
                    
                if curr.left is not None:
                    q.append(curr.left)
                    q.append(curr.right)
                
                prev = curr
                
        return root
                
            
            
"""
M2 - Optimized BFS
We can reduce the aux space as we can perform the BFS without a queue and still establish the connection
We maintain a level pointer to every level's beginning and esablish connections in that level using curr pointer

TC = O(n)
SC = O(1)

"""
            
class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
    
        if not root:
            return root
        level = root
        
        while level.left:
            curr = level
            
            while curr:
                curr.left.next = curr.right
                
                if curr.next:
                    curr.right.next = curr.next.left
                
                curr = curr.next
            level = level.left
        return root
        
        
"""
M3 - we use the symmetry of the tree to establish connections and recursively call the helper function to establish all types of connections

TC = O(n)
SC = O(h)

"""   
"""
M4 - DFS approach

""" 