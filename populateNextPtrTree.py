# // Time Complexity :O(n)
# // Space Complexity :O(n) worst case; best case O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

# dfs special T:O(n), S:O(h)
class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if not root: return
        self.dfs(root.left,root.right)
        return root

    def dfs(self, left, right):       
        
        if not left: return
        left.next = right

        self.dfs(left.left, left.right)
        self.dfs(left.right,right.left)
        self.dfs(right.left, right.right)

# levelorder queue T:O(n), S:O(n) ... space n/2
from collections import deque
class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if not root : return 
        q = deque()
        q.append(root)

        while q:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                if i != size-1:
                    curr.next = q[0]
                if curr.left:
                    q.append(curr.left)
                    q.append(curr.right)
        return root
    
# iterative T:O(n), S:O(1)
class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
            if not root: return None
            
            level = root

            while level.left:
                curr = level
                while curr:
                    curr.left.next = curr.right
                    if curr.next:
                        curr.right.next = curr.next.left
                    curr = curr.next
                level = level.left
            return root
    
#DFS T:O(n), S:O(n)
class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if not root: return
        self.dfs(root)
        return root

    def dfs(self,curr):
        #basecase
        if not curr.left: return

        curr.left.next = curr.right
        if curr.next:
            curr.right.next = curr.next.left

        self.dfs(curr.left)
        self.dfs(curr.right) 