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
        
        if not root:
            return 
        
#         q = [root]
        
#         while (q):
#             temp = []
            
            
#             while (q):
#                 curr =q.pop(0)
            
#             if q:
#                 curr.next = q[0]
#                 if curr.left!=None:
#                     temp.append(curr.left)
#                 if curr.right!=None:
#                     temp.append(curr.right)
#             q = temp
                    
#         return root

        stack =list([root])
        while(stack):
            newStack = []
            while(stack):
                node = stack.pop(0)
                if stack:
                    node.next = stack[0]
                if node.left: newStack.append(node.left)
                if node.right: newStack.append(node.right)
            stack = newStack
        return root


 

                
            
        