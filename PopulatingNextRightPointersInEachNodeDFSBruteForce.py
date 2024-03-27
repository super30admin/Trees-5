'''
TC: O(n) - n is the number of nodes in the tree
SC: O(n) - stack space
Using DFS
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
        #DFS TC: O(n) SC: O(n)

        def dfs(root):
            if not root or not root.left:
                return 
            root.left.next = root.right
            if root.next:
                root.right.next = root.next.left
            dfs(root.left)
            dfs(root.right)

        dfs(root)
        return root