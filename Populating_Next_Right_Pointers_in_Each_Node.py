'''

Brute Force - Level Order Traversal - TC - O(N) SC - O(N)

Better Approach - 
TC- O(N)
SC- O(1)

Algorithm - Step 1 - Taking the leftmost vlaue as root and point next of its left to right
            Step 2 - If right of the current head exists, then point next of right of head to next of left of head

Code accepted on leetcode
'''
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next


class Solution:
    def connect(self, root: 'Node') -> 'Node':
        
        # base case
        if root == None:
            return root
        
        leftmost = root 
        while leftmost.left: # Iterating through all the leftmost nodes
            head = leftmost # since we need to traverse only leftmost node, so we have to keep hold of leftmost node
            while(head):
                head.left.next= head.right
                if head.next != None:
                    head.right.next= head.next.left
                head=head.next
            leftmost=leftmost.left
            
        return root