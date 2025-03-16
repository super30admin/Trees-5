# Using DFS recursion
# Time O(n)
# Space O(h)
class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        self.dfs(root)
        return root

    def dfs(self, root: 'Optional[Node]') -> None:
        if root == None: return

        if root.left != None and root.right != None:
            root.left.next = root.right
            if root.next != None: root.right.next = root.next.left
        
        self.dfs(root.left)
        self.dfs(root.right)

# Using DFS stack
# Time O(n)
# Space O(n)
class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        stack = []
        rootOrig = root
        while len(stack) > 0 or root != None:
            while root != None:
                if root.left != None and root.right != None:
                    root.left.next = root.right
                    if root.next != None: root.right.next = root.next.left
                stack.append(root)
                root = root.left
            root = stack.pop()
            root = root.right
        return rootOrig

# Using BFS
# Time O(n)
# Space O(n) 
from collections import deque
class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        dq = deque()
        if root != None: dq.append(root)
        while len(dq) > 0:
            l = len(dq)
            for i in range(l):
                curr = dq.popleft()
                if i < l-1:curr.next = dq[0]
                if curr.left != None: dq.append(curr.left)
                if curr.right != None: dq.append(curr.right)
        return root