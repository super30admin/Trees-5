# Time Complexity : O(N) whenre N is number of Nodes in the tree
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


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
        if root == None:
            return None
        level = root
        while level.left != None:
            curr = level
            
            while curr != None:
                curr.left.next = curr.right
                
                if curr.next != None:
                    curr.right.next = curr.next.left
                    
                curr = curr.next
                    
            level = level.left
            
        return root    