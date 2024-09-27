"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""
# Time : O(n)
# Space : O(1)

class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if(root == None):
            return None
        # level pointer to move to next level after processing current level
        level = root
        
        while(level.left != None):
            curr = level
            # perfect tree will have two children or no children
            while(curr != None):
                # connect sibling nodes
                curr.left.next = curr.right
                # connect cousin nodes if parent node's sibling exsists
                if(curr.next != None):
                    curr.right.next = curr.next.left
                # move forward on same level
                curr = curr.next
            # move to the next level of nodes
            level = level.left
        
        return root