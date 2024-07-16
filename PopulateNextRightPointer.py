# Time Complexity:
# O(n) 

# Space Complexity:  
# O(1)   

# Approach: 
# Iterative solution, Use pointers to modify the .next pointer of each node while moving the curr pointer.

"""
# Definition for a Node.
class Node(object):
    def __init__(self, val=0, left=None, right=None, next=None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

class Solution(object):
    def connect(self, root):
        """
        :type root: Node
        :rtype: Node
        """
        if not root:
            return
        # Iterative solution    ==> TC = O(n), SC = O(1)
        leftNode = root

        # Traverse untill leftNode's "left" child is valid
        while(leftNode.left):
            curr = leftNode
            while(curr):
                # 1. Setting "left"'s next to "right" node
                curr.left.next = curr.right

                # 2. Setting "right" node's next to its next right node in same level
                if curr.next:
                    curr.right.next = curr.next.left

                # advance the curr pointer
                curr = curr.next
            
            # advance the leftNode pointer
            leftNode = leftNode.left
        
        return root