# Approach 1 - Use BFS (queue) to traverse level by level and add the pointers to the next node on that level
# This will be done after the first node onwards, at every level keep updating the prev to the next node in that level

# Time - O(N) #iterating over all nodes
# Space - O(N) #queue used for space

# Definition for a Node


class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next


class Solution:
    def connect(self, root: 'Node') -> 'Node':
        
        result = []
        
        # base case
        if root == None:
            return None
        
        queue = collections.deque()
        queue.append(root)
        
        while queue:
            
            size = len(queue)
            prev = None
            
            for i in range(size):
                node = queue.popleft()
                
                if prev:
                    prev.next = node
                    
                if (node.left):
                    queue.append(node.left)
                    
                if (node.right):
                    queue.append(node.right)
                    
                prev = node
                
        return root
                    
                
               
# Approach 2 - Using BFS, make use of the pointers instead of declaring queue use the pointers 
# Time - O(N)
# Space - O(1)

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
        
        result = []
        
        # base case
        if root == None:
            return None
        
        level = root
        
        while level.left != None:
            
            current = level
            
            while current != None:
                
                current.left.next = current.right
                
                if current.next != None:
                    
                    current.right.next = current.next.left
                    
                current = current.next
            
            level = level.left
            
        return root
                    
                


## Approach 3: DFS

# time - O(N)
# space - O(N) recursive call stack

class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next


class Solution:
    def connect(self, root: 'Node') -> 'Node':
        
        if root == None:
            return None
        
        self.dfs(root.left, root.right)
        return root
    
    
    def dfs(self, left, right):
        
        # base case
        if left == None:
            return 
        
        # logic
        left.next = right
        self.dfs(left.left, left.right)
        self.dfs(left.right, right.left)
        self.dfs(right.left, right.right)
                        
                    
                    
                    
                    
                    
                    
                    
            
            
           
        
        