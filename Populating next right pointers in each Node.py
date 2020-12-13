# Time:- O(n)
# Space:- O(1) Recursive stack space is not counted as space according to the problem description
# Approach:- Maintain a list of nodes seen for the first time at each level, next time we see a node at that level,
# we will point the next pointer of the previous node at that level to this new node and change the node at this level
# to this new node.
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
        def conn(root,arr,i):
            if root is None:
                return
            if i<len(arr) and arr[i]!=root:
                arr[i].next=root
                arr[i]=root
            else:
                arr.append(root)
            conn(root.left,arr,i+1)
            conn(root.right,arr,i+1)
        conn(root,[],0)
        return root
        
        
        