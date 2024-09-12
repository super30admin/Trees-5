"""
116. Populating Next Right Pointers in Each Node
Time Complexity - O(n)
Space Complexity -O(1)
Here we have a level pointer that keeps track of left most or head of the list fot that level
and a curr pointer that moves along the nodes in that level root.
If curr had left node then join left node with right node and if there is next element to that node then point curr.right -> curr.next.level
increment curr until node and increment level as well"""
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
            return root
        level = root
        while(level != None):
            curr = level
            if curr.left == None and curr.right == None:
                break
            while(curr != None):
                curr.left.next = curr.right
                if curr.next != None:
                    curr.right.next = curr.next.left
                curr = curr.next
            level = level.left
        return root
                
            
        