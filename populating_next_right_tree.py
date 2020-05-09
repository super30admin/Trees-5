"""
// Time Complexity : O(n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
Algorithm explanation
Method 1- BFS with updating next pointer for current root using two pointer (prev, curr)
mechanism

Set prev to None at the start of each level
curr = queue.poll()
if prev is not None
    prev.next = curr
curr.next = None
prev = curr

Method 2 & 3
Method2 - Using two pointers, temp and curr (Level order)
        temp -> updating the pointer per level
        curr -> iterating over the nodes along the level 
        
        Cases
            - if curr.left -> curr.left.next = curr.right
            - if curr.right -> curr.right.next = curr.next.left

Method3  - Two pointers(Depth first)
        - The only difference from the above method is that we go along the left  subtree and the subtree  and we don't update curr = curr.next per level
"""
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
    def connect(self, main: 'Node') -> 'Node':
        """
        Method 1- BFS with updating next pointer for current root using two pointer (prev, curr)
        mechanism - Space suboptimal
        
        Method2 - Using two pointers, temp and curr (Level order)
        temp -> updating the pointer per level
        curr -> iterating over the nodes along the level 
        
        Cases
            - if curr.left -> curr.left.next = curr.right
            - if curr.right -> curr.right.next = curr.next.left
        
        Method3  - Two pointers(Depth first)
        - The only difference from the above method is that we go along the left  subtree and the subtree  and we don't update curr = curr.next per level
        
        
        """
        result = []
        if not main:
            return main
        q = deque([main])
        while q:
            size = len(q)
            prev = None
            for _ in range(size):
                root = q.popleft()
                #curr = root
                #updating the next pointer
                if prev:
                    prev.next = root
                root.next = None
                prev = root
                
                if root.left:
                    q.append(root.left)
                if root.right:
                    q.append(root.right)
        return main
        
        #Space optimal solution - Level order
        temp = main
        curr = None
        if not main:
            return main
        while temp.left:
            curr = temp #updating the curr to current node of the level
            while curr: #keeping check of the level 
                if curr.left:
                    curr.left.next = curr.right
                if curr.next:
                    curr.right.next = curr.next.left
                curr = curr.next
            temp = temp.left
        return main
        
        #Method3 - DFS solution
        def dfs(root):
            if not root:
                return
            
            if root.left:
                root.left.next = root.right
            if root.right and root.next:
                root.right.next = root.next.left
            
            dfs(root.left)
            dfs(root.right)
        
        dfs(main)
        return main