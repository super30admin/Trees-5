"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""
#TC:O(n)
#SC:O(n)
#Algorithm:
#explore the children of nodes, and point the curr.left .next to curr.right, and update cuur node to cuur.next
class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if root==None:
            return None
        
        q=deque()
        if root:
            q.append(root)
        while q:
            size=len(q)
            prev=q.popleft()
           
            if prev.left:
                q.append(prev.left)
            if prev.right:
                q.append(prev.right)
            
            for _ in range(1,size):
                
                curr=q.popleft()
                prev.next=curr
                prev=curr
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
        return root
#TC:O(n)
#SC:O(1)
#No use of extra space.

class Solution:
    def connect(self, root: 'Node') -> 'Node':
        
        pre = root
        
        while pre:
            curr = pre
            while curr:
                if curr.left:
                    curr.left.next = curr.right
                    if curr.next:
                        curr.right.next = curr.next.left
                curr = curr.next
            pre = pre.left
        
        return root
