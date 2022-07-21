# time is o(n), where n is number of nodes in a tree.
# space(Recursive) is o(1).
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
        level = root
        while(level != None):
            curr = level
            while(curr):
                if(curr.left):
                    curr.left.next = curr.right
                    if(curr.next != None):
                        curr.right.next = curr.next.left
                curr = curr.next
            level = level.left
        return root
        
        
#         Recursive solution

#         time is o(n), where n is number of nodes in a tree
#         space(Recursive) is o(h), where h = log(n), n is number of nodes in a tree

#         self.first = None
#         self.second = None
#         self.prev = None
#         self.helper(root)
#         return root
        
#     def helper(self, root):
#         if(root == None):
#             return None
        
#         if(root.left):
#             root.left.next = root.right
#             if(root.next !=  None):
#                 root.right.next = root.next.left
#         self.helper(root.left)
#         self.helper(root.right)
        
        