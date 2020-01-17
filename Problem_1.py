# Runs on Leetcode
    # Solution 1
        # Runtime - O(n)
        # Memory - O(n)
    # Solution 2
        # Runtime - O(n)
        # Memory - O(1)

"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""


# Solution 1

class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if not root:
            return 
        queue = [root]
        while queue:
            first = queue[0]
            for i in range(len(queue)-1):
                queue[i].next = queue[i+1]
            temp = queue
            queue = []
            for i in range(len(temp)):
                if temp[i].left:
                    queue.append(temp[i].left)
                if temp[i].right:
                    queue.append(temp[i].right)
        return root
        
        
# Solution 2

class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if not root:
            return 
        temp = root
        while temp:
            curr = temp
            while curr:
                if curr.left:
                    curr.left.next = curr.right
                if curr.right and curr.next:
                    curr.right.next = curr.next.left
                curr = curr.next
            temp = temp.left
        return root
