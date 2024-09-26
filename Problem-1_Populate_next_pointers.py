# APPROACH  1: BRUTE FORCE: LEVEL ORDER TRAVERSAL
# Time Complexity : O(n), n: number of nodes
# Space Complexity : O(n), as max size of queue is n / 2 due to last level - max number of leaves
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Do level order traversal of tree (BFS using queue)
# 2. Iterate only till second last node of the level and set the next pointers of each of them to its' next node (the one at front of queue)

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
        
        if root is None:
            return None
        
        queue = deque()
        queue.append(root)
        
        while queue:
            level_size = len(queue)
            while level_size > 0:
                node = queue.popleft()
                if level_size != 1:
                    node.next = queue[0]
                    
                if node.left is not None: queue.append(node.left)
                if node.right is not None: queue.append(node.right)
                    
                level_size -= 1
                
        return root
                
                
        
        

# APPROACH 2: OPTIMAL: PREVIOUS LEVEL APPROACH
# Time Complexity : O(n), n: number of nodes
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Access the next level's nodes from the curr_level's child pointers
# 2. For a node, point it's left child to right child and right child to the left child of the node's next. Then set the node to node's next. 
# 3. Keep track of level, to access to next level by moving left ( only leftmost nodes of each level). 

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
        
        if root is None:
            return None
        
        level, curr = root, root
        
        while level.left is not None:
            curr = level
            
            while curr is not None:
                
                curr.left.next = curr.right
                if curr.next is not None:
                    curr.right.next = curr.next.left
                curr = curr.next
                
            level = level.left
            
        return root
                
                
        
        
        

# APPROACH  3: DFS
# Time Complexity : O(n), n: number of nodes
# Space Complexity : O(n), recursive stack space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Start with root's children. Each recursive call, point the next of node1 to node2
# 2. Then recursively call on node1's children, node1's right and node2's left and node2's children

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
        
        if root is None:
            return None
        
        self.dfs(root.left, root.right)
        return root
    
    
    def dfs(self, node_1, node_2):
        if node_1 is None or node_2 is None:
            return
        
        node_1.next = node_2
        
        self.dfs(node_1.left, node_1.right)
        self.dfs(node_1.right, node_2.left)
        self.dfs(node_2.left, node_2.right)
                
                
        
