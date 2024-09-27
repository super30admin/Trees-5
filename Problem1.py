#Time Complexity: O(N)
#Space Complexity: O(N)
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
        if not root:
            return None
        queue = [root]
        
        while queue:
            length = len(queue)
            for i in range(length):
                node = queue.pop(0)
                if i < length - 1:
                    node.next = queue[0]
                if node.left:   
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
                    
                    
        return root
                    
        
                
            
                
                
            
        