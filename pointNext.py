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
    
    """
    Description: Populate next right pointers in each node
    
    Time Complexity: O(n)
    Space Complexity: O(n)
    
    Approach: 
    - Use a new node list at each level of the tree
    - record previous node and point the next value to the current  node
    - keep elements in list for every node until all the nodes are taken care of
    """
    
    def connect(self, root: 'Node') -> 'Node':
    
        from collections import deque
        
        if root == None: return

        nodes = [root]
        while len(nodes) != 0:
            node_list = []
            prev = None
            for node in nodes:
                if prev is not None:
                    prev.next = node
                if node.left is not None:
                    node_list.append(node.left)
                    node_list.append(node.right)
                prev = node
            nodes = node_list

        return root

# Optimized solution (BFS)
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
    
    """
    Description: Populate next right pointers in each node
    
    Time Complexity: O(n)
    Space Complexity: O(1)
    
    Approach: 
    - use nodes at each level of the tree (left side)
    - for each level rewire the .next pointer for children of the node
    - continue until there is no more nodes on left of last level
    """
    
    def connect(self, root: 'Node') -> 'Node':
            
        if root == None: return
        
        level = root
        while level.left:
            curr = level
            while curr:
                curr.left.next = curr.right
                if curr.next != None:
                    curr.right.next = curr.next.left
                curr = curr.next
            level = level.left
        return root

# Using DFS:
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
    
    """
    Description: Populate next right pointers in each node
    
    Time Complexity: O(n)
    Space Complexity: O(h)
    
    Approach: Using DFS
    - connect nodes left -> right, right -> left (for left.left), and left -> right (for left.right)
    - recursively call until left == None
    """
    
    def connect(self, root: 'Node') -> 'Node':
            
        if root == None: return
        
        self.dfs(root.left, root.right)
        return root
    
    def dfs(self, left, right):
        
        # base
        if left == None: return
        
        # logic
        left.next = right
        self.dfs(left.left, left.right)
        self.dfs(left.right, right.left)
        self.dfs(right.left, right.right)
        
