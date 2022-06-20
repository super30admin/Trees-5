'''
Using BFS
Time: O(n)
Space: O(n)
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
from collections import deque
class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if root is None:
            return None
        q = list()
        q.append(root)
        while len(q) != 0:
            size = len(q)
            for i in range(size):
                curr = q.pop(0)
                if i < size - 1:
                    curr.next = q[0]
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
        return root


'''
Using prev pointer
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
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        
        if root is None:
            return None
        
        q = list()
        q.append(root)
        while len(q) != 0:
            size = len(q)
            prev = None
            for i in range(size):
                curr = q.pop(0)
                
                if i > 0:
                    prev.next = curr
                prev = curr
                
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
                prev = curr
        
        return root


'''
Using next pointer (LL) logic
Time: O(n)
Space: O(1)
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
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if root is None:
            return None
        
        level = root
        curr = root
        
        while level.left != None:
            curr = level
            while curr != None:
                curr.left.next = curr.right
                if curr.next != None:
                    curr.right.next = curr.next.left
                curr = curr.next
            level = level.left
        
        return root




'''
Using DFS logic
Time: O(n)
Space: recursive stack
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
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if root is None:
            return None
        
        self.dfs(root.left, root.right)
        
        return root
    
    def dfs(self,left,right):
        if left is None:
            return
        
        if left.next != None: return
        
        left.next = right
        
        self.dfs(left.left, left.right)
        self.dfs(left.right, right.left)
        self.dfs(right.left, right.right)



'''
Using DFS logic (single parameter - root)
Time: O(n)
Space: recursive stack
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
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if root is None:
            return None
        
        self.dfs(root)
        
        return root
    
    def dfs(self,root):
        if root.left is None:
            return
        
        root.left.next = root.right
        self.dfs(root.left)
        if root.next != None:
            root.right.next = root.next.left
        self.dfs(root.right)
        