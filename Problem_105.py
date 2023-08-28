# TC : O(N)
# SC : O(N)

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
        self.levels = [[]]
        def dfs(root, level):
            if not root:
                return
            if level == len(self.levels):
                self.levels.append([])
            self.levels[level].append(root)

            dfs(root.left, level+1)
            dfs(root.right, level+1)

        dfs(root, 0)
        for i in range(0, len(self.levels)):
            for j in range(1, len(self.levels[i])):
                self.levels[i][j-1].next = self.levels[i][j]

        return root
