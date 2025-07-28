# TimeComplexity:O(h)
# SpaceComplexity:O(1)

# Appraoch:This can be using bfs but that takes O(n) space complexity to reduce the space complexity we KNOW THIS IS PERFECT BINARY TREE so we always have left most pointer to give us start
# and other pointer for conencting 






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
        q=deque([root])
        if root==None:return None
        while(len(q)):
            l=len(q)
            prev=root
            for i in range(l):
                node=q.popleft()
                if node.left:q.append(node.left)
                if node.right:q.append(node.right)
                if i!=0:
                    # print(node.val)
                    prev.next=node
                if i==l-1:
                    node.next=None
                   
                prev=node
        return root








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
        #you willhave 2 pointers one for level and other for connecting. nodes in level;
        # edge case single node ,zero node
        level=root
        curr=root
        while(level !=None):
            while(curr !=None):
                if curr.left:
                    curr.left.next=curr.right
                if curr.next!=None:
                    curr.right.next=curr.next.left
                curr=curr.next
            curr=level
            level=level.left
        return root
