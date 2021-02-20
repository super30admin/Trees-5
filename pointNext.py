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
