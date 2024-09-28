#time complexity: O(n)
#space complexity: O(1)
#ran on leetcode: Yes
# start from the first level(root) and establish the right pointer connection for next level. Now move to next level and traverse this level like a linked list. While traversing this level establish the connections for the next level. Do this for all levels.
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
        p=root
        if(root==None):
            return root
        while(p.left):
            q=p
            while(q!=None):
                
                q.left.next=q.right
                if(q.next!=None):
                    q.right.next=q.next.left
                q=q.next
            p=p.left
        return root
