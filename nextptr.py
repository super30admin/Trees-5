#As taught in class, using DFS to solve this problem
#Time Complexity: O(h)
#Space Complexity: O(1)
class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if root is None:
            return
        self.dfs(root.left,root.right)
        return root
    
    def dfs(self,left,right):
        if left is None and right is None:
            return
            
        left.next = right
        self.dfs(left.left,left.right)
        self.dfs(left.right,right.left)
        self.dfs(right.left,right.right)
