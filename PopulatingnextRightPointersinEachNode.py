"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""
from collections import deque
class Solution:
    def connect(self, root: 'Node') -> 'Node':
        """DFS Approach on root's left and right
        Time complexity-O(n)
        Space complexity-O(1) as stack space is underhood one"""
        if not root:
            return
        self.dfs(root.left, root.right)
        return root
    
    def dfs(self, left, right):
        if not left:
            return
        left.next=right
        self.dfs(left.left, left.right)
        self.dfs(left.right, right.left)
        self.dfs(right.left, right.right)
        
        """Optimized BFS solution by not using extra queue space
        Time complexity-O(n)
        Space complexity-O(1), underhood using stack of h space"""
        # level=root
        # while level:
        #     curr=level
        #     while curr:
        #         if curr.left:
        #             curr.left.next=curr.right
        #             if curr.next!=None:
        #                 curr.right.next=curr.next.left
        #         curr=curr.next
        #     level=level.left
        # return root
        
        """Using BFS
        Time complexity-O(n)
        Space complexity-O(h) as utilizing queue"""
        # if not root:
        #     return
        # q=deque()
        # q.append(root)
        # while q:
        #     cnt=len(q)
        #     prev=q.popleft()
        #     if prev.left:
        #         q.append(prev.left)
        #         q.append(prev.right)
        #     for i in range(1, cnt):
        #         curr=q.popleft()
        #         if curr.left:
        #             q.append(curr.left)
        #             q.append(curr.right)
        #         prev.next=curr
        #         prev=prev.next
        # return root
                
                
        
        