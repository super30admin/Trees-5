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
        if(root==None):
            return None
        queue = [root]
        
        while(len(queue)!=0):
            size = len(queue)
            curr = queue.pop(0)
            if(curr.left!=None):
                queue.append(curr.left)
                queue.append(curr.right)
            for i in range(1,size):
                now = queue.pop(0)
                curr.next=now
                if(now.left!=None):
                    queue.append(now.left)
                    queue.append(now.right)
                curr = now
        return root
                
        