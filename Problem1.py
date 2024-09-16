"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

"""

    Name : Shahreen Shahjahan Psyche
    Time : O(N) [Where N is the number of nodes]
    Space: With Queue : O(N/2) [Maximum Number of children in a level is  N/2]
           Without    : O(1)
           
    Passed all Test cases in LC : Yes

"""


class Solution:
    
    # This method performs the task without using any extra space
    def connectWithoutQueue(self, root):
        head = root
        while head:
            while root:
                # First, connecting the 2 child of the tree node
                if root.right:
                    root.left.next = root.right
                # After coonnecting them, if there is a next nodee for my current treenode, then coonneecting the current tree 
                # tree node's right child to the next tree node's left child
                if root.next and root.right:
                    root.right.next = root.next.left 
                root = root.next 
            head = head.left
            root = head  

            
    # This method follows the traditional bfs - level by level maintaining a queue
    def connectWithQueue(self, root):
        
        from collections import deque
        
        q = deque()
        q.append(root)

        while q:
            size = len(q)
            i = 0
            # travarse level by level and while iterating through each leevel, it connects the child
            while(i < size):
                curr = q.popleft()
                if i == size - 1:
                    curr.next = None
                else:
                    curr.next = q[0]
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
                i += 1
        return 
    
    def connect(self, root: 'Node') -> 'Node':
        
        if not root:
            return
        
        head = root
        
        # self.connectWithQueue(head)
        self.connectWithoutQueue(head)
        
        return root
        
        
        
        
