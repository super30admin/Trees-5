# Time Complexity : O(N)
# Space Complexity : O( size of last level of tree)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach

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
        """
        can do level order.. 
            - when new level occurs..reset pointer
            
        """
        
        if not root:
            return
        
        queue = deque([root])
        
        while queue:
            size = len(queue)
            #indicate new lvl when it hits this line
            nextLvlVal = None
            
            for i in range(size):
                curr = queue.popleft()
              
                if nextLvlVal:
                    nextLvlVal.next = curr
                    
                nextLvlVal = curr
                #fill up queue for next lvl
                if curr.left:
                    queue.append(curr.left)
                if curr.right:
                    queue.append(curr.right)
                    
        return root