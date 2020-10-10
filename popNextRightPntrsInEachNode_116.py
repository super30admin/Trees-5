# // Time Complexity : 
# // Space Complexity : 
# // Did this code successfully run on Leetcode : 
# // Any problem you faced while coding this : 

# // Your code here along with comments explaining your approach: 

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
            return root

        # initialise queue with the root     
        queue = [root]
    
        # while queue is not empty maintain size of queue at all levels and keep adding all nodes in the queue level wise
        # if popped node's left or right exist: add them to the queue in that order
        while queue:
            size = len(queue)
            #iterating over all nodes at same level
            for x in range(size):
                #pop if at the last iteration and add to output
                front = queue.pop(0)
                #in case 
                if x < size-1:
                    front.next = queue[0]
                
                if front.left is not None:
                    queue.append(front.left)
                if front.right is not None:
                    queue.append(front.right)
            
        return root