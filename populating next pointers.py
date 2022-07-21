# Time Complexity: O(n)
# Space Complexity: O(n)
# BFS

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
        if root==None: return root
        q=[]
        q.append(root)
        while q:
            prev=None
            cur=None
            k=None
            for i in range(len(q)):
                cur=q.pop(0)
                if prev!=None:
                    prev.next=cur
                if cur.left!=None:
                    q.append(cur.left)
                    q.append(cur.right)
                prev=cur
            prev.next=None
        return root

# Time Complexity: O(n)
# Space Complexity: O(1)
# Pointer Approach
'''
class Solution(object):
    def connect(self, root):
        if root==None: return root
        level=root
        while level.left!=None:
            cur=level
            while cur!=None:
                cur.left.next=cur.right
                if cur.next!=None:
                    cur.right.next=cur.next.left
                cur=cur.next  
            level=level.left
        return root
'''


# Time Complexity: O(n)
# Space Complexity: O(h)
# DFS from 2 sides
'''
class Solution(object):
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if root==None: return root
        self.dfs(root.left,root.right)
        return root
    def dfs(self, left: 'Optional[Node]',right: 'Optional[Node]'):
        if left==None: return
        left.next=right
        self.dfs(left.left,left.right)
        self.dfs(left.right,right.left)
        self.dfs(right.left,right.right)
'''

# Time Complexity: O(n)
# Space Complexity: O(h)
# DFS
    # def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
    #     if root==None: return root
    #     self.dfs(root)
    #     return root
    # def dfs(self, root: 'Optional[Node]'):
    #     if root.left==None: return
    #     root.left.next=root.right
    #     if root.next!=None:
    #         root.right.next=root.next.left
    #     self.dfs(root.left)
    #     self.dfs(root.right)