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
            return root
        
        def dfs(lNode, rNode):
            if not lNode:
                return

            lNode.next = rNode            

            dfs(lNode.left, lNode.right)
            dfs(rNode.left, rNode.right)
            dfs(lNode.right, rNode.left)

        dfs(root.left, root.right)
        return root