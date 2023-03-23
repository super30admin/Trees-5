#Time Complexity :- O(n)
#Space Complexity :- O(1)

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
        
        level = root
        curr = None 

        while level.left is not None:
            curr = level
            while curr is not None:
                curr.left.next = curr.right
                if curr.next is not None:
                    curr.right.next = curr.next.left
                curr = curr.next
            level = level.left
        return root
        


#Another approach BFS;
#Time Complexity :- O(n)
#Space Complexity :- O(2^l) where l is the level

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
        queue = []
        queue.append(root)

        while len(queue) > 0:
            size = len(queue)
            i = 0
            while i < size:
                current = queue.pop(0)
                if len(queue) > 0 and i!=size-1:
                    current.next = queue[0]
                i+=1
                if current is not None and current.left is not None:
                    queue.append(current.left)
                if current is not None and current.right is not None:
                    queue.append(current.right)
                
        return root


#Another Appoach DFS :

#Time Complexity :_ O(n)
#Space Complexity :- O(h)

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
        if root is None :
            return root
        
        self.dfs(root.left, root.right)
        return root
    
    def dfs(self, left, right):
        if left is None:
            return 
        
        left.next = right

        self.dfs(left.left, left.right)
        self.dfs(left.right, right.left)
        self.dfs(right.left, right.right)