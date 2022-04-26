"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

#Time Complexity: O(n)
#Sapce Complexity : O(1)

class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        main = root
        if (root == None):
            return
        root.next = None
        while(root):
            head = root
            while( root != None and root.left != None):
                root.left.next = root.right
                if (root.next != None):
                    root.right.next = root.next.left
                else:
                    root.right.next = None
                root = root.next
            root = head.left
        return main
