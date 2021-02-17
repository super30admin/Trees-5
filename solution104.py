#Time Complexity:O(n)
#Space Complexity:O(1)
"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

#Two pinter or level order traversal.
class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if not root:
            return None
        level=root                                      #assign the level pointer while parsing each level
        while level.left:                               #while the next level exists
            curr=level                                  #parse ech node in that level using curr pointer
            while curr:                                 #while curr node exists
                curr.left.next=curr.right               #point left child to right child
                if curr.next:                           #assign right child to next node's left child while next node of the same level exists
                    curr.right.next=curr.next.left
                curr=curr.next                          #move curr pointer to next node
            level=level.left                            #move to next level
        return root