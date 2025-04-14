# // Time Complexity :O(n)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


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
    def connect(self, root: 'Node') -> 'Node':
        if root is None: return root
        self.bfs(root)
        return root
    def bfs(self,root):
        #base
        if root.left is None:
            return
        #logic
        curr=root
        print(curr.val)
        while curr:
            curr.left.next=curr.right
            if(curr.next):
                curr.right.next=curr.next.left
            curr=curr.next
        self.bfs(root.left)
            
        
        