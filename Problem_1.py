# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on leetcode : Yes
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
          
        if not root:
            return root
        
        # initialize the first child of the level 
        firstChild = root
        
        while firstChild:
            actual = firstChild
            firstChild = firstChild.left
            
            # while the actual level has siblings, we keep looping, if not we finish this while and we move into the next level
            while actual:
                if actual.left:
                    # connect left child with right child of the same node
                    actual.left.next = actual.right
                    # if the next sibling exists and it has a left child, we connect the actual right child with the next left child
                    if actual.next:
                        actual.right.next = actual.next.left
                else:
                    break
                # update the actual node with the next sibling (at the same level)
                # if the next sibling is Null, this loops ends and we go to the next level
                actual = actual.next
        
        return root