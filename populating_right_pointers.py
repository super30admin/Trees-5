# // Time Complexity : O(n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Nope


# // Your code here along with comments explaining your approach



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
        if not root:
            return None
        
        #Setting the first level
        level=root
        
        #Traverse until we have the next left node 
        while level.left:
            curr=level
            while curr:
                curr.left.next=curr.right
            
                #If there is the right node 
                if curr.next:
                #Point the left to the right
                    curr.right.next=curr.next.left
                
                #Move the curr pointer
                curr=curr.next
            #Move the level to the next left
            level=level.left
        
        return root