#Time Complexity :o(N) where N is number of elements
#sPACE coMPLEXITY : o(n) where N is number of elements
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
    def connect(self, root: 'Node') -> 'Node':
        q = []
        if root == None:
            return None
        q.append(root)
        while(len(q)!=0):
            size = len(q)
            prev = q.pop(0)
            if (prev.left!=None):
                q.append(prev.left)
            if (prev.right!=None):
                q.append(prev.right) 
            for i in range(1,size):
                curr = q.pop(0)
                prev.next = curr
                prev = curr
                if (curr.left!=None):
                    q.append(curr.left)
                if (curr.right!=None):
                    q.append(curr.right)
        return root
====================================================================================================
#Time Complexity :o(N) where N is number of elements
#sPACE coMPLEXITY : o(1)
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
    def connect(self, root: 'Node') -> 'Node':
        if root == None:
            return None
        level = root
        while (level.left != None):
            curr = level
            while(curr!=None):
                curr.left.next = curr.right
                if curr.next!=None:
                    curr.right.next = curr.next.left
                curr = curr.next
            level = level.left
        return root
