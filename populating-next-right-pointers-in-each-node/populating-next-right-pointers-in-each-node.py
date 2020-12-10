"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""
​
class Solution:
    def connect(self, root: 'Node') -> 'Node':
        
        def dfs(left,right):
            #base
            if left == None:
                return
            
            #logic
            left.next = right
            dfs(left.left,left.right)
            dfs(left.right,right.left)
            dfs(right.left,right.right)
            
        
        if root is None:
            return root
        
        dfs(root.left,root.right)
        return root
        
