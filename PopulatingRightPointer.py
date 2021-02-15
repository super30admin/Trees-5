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
        '''
        With extra space
        if(root==None):
            return root
        q = deque([root])
        
        while(len(q)>0):
            size = len(q)
            prev = None
            for i in range(0,size):
                z = q.popleft()
                if(prev != None):
                    prev.next = z
                    prev = prev.next
                else:
                    prev = z
                if(z.left!=None):
                    q.append(z.left)
                if(z.right!=None):
                    q.append(z.right)
                
        
        
        return root
        '''
        # Time Complexity: O(n)
        # Without extra space
        def connect1(root,prev):
            if(root==None):
                return
            if(prev!=None):
                prev.next = root
                prev = prev.right
            else:
                prev = None
            
            #if(root.left!=None):(fully connected tree)
            connect1(root.left,prev)
            
            prev = root.left
            #if(root.right!=None): (fully connected tree)
            connect1(root.right,prev)
                
        connect1(root,None)
        return root
