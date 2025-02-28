#approach 1 inorder BFS
#time: O(n)
#space:O(n)
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
        if root is None:
            return
        q=[]
        q.append(root)
        while len(q) !=0:
            size= len(q)
            for i in range(size):
                curr= q.pop(0)
                if curr.left is not None:
                    q.append(curr.left)
                if curr.right is not None:
                    q.append(curr.right)
                if i == (size-1):
                    continue
                curr.next = q[0]
        return root 


#using inorder dfs
#time: O (n)
# space: O(1)
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
        if root is None:
            return
        self.dfs(root)
        return root
    def dfs(self,root):
        if root is None:
            return root
        curr= root
        if curr.left is not None:
            curr.left.next = curr.right
        if curr.next is not None and curr.right is not None:
            curr.right.next= curr.next.left
        self.dfs(curr.left)
        self.dfs(curr.right)
        return root 
