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
Space complexity O(H)[recursive space]


"""
class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if root is None:
            return None
        self.dfs(root.left,root.right)
        return root
    
    def dfs(self,left,right):
        #base
        if left is None: # no need to check right as it is perfect Btree
            return 
        
        #logic
        left.next=right
        self.dfs(left.left,left.right)
        self.dfs(left.right,right.left)
        self.dfs(right.left,right.right)
        
        
        
      
        