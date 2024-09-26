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

        ## Approach 3:
        ## T.C = O(n)
        ## S.C = O(h)

        def dfs(left, right):
            if not left:
                return
            
            left.next = right

            dfs(left.left, left.right)
            dfs(left.right, right.left)
            dfs(right.left, right.right)
        
        dfs(root.left, root.right)
        return root
        

        ## Approach 2: 
        ## T.C = O(n)
        ## S.C = O(1)
        
        left = root

        while left.left:
            curr = left
            while curr:
                curr.left.next = curr.right
                if curr.next:
                    curr.right.next = curr.next.left

                curr = curr.next
            left = left.left
            
        return root

        ## Approach 1: 
        ## T.C = O(n)
        ## S.C = O(n)
        
        q = [root]

        while q:
            size = len(q)
            
            curr = q.pop(0)
            if curr and curr.left is not None:
                q.append(curr.left)
                q.append(curr.right)

            for i in range(size - 1):
                x = q.pop(0)
                if x.left is not None:
                    q.append(x.left)
                    q.append(x.right)

                curr.next = x
                curr = curr.next
        
        return root
        
        