"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

# # Optimal SOlution: BFS with realized connections
# # TC: O(n)
# # SC = O(1)
# class Solution:
#     def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        
#         if not root:
#             return
        
#         level = root
        
#         while(level.left): 
#             # As long as there is a valid child at each level, we go inside the loop. Question mentioned that given tree is a complete binary tree
#             curr = level
            
#             while(curr):
#                 curr.left.next = curr.right
#                 if curr.next is not None:
#                     curr.right.next = curr.next.left
#                 curr = curr.next
            
#             level = level.left
                
        
#         return root

# # Brute Force Level Order
# # TC: O(n)
# # SC = Width of the tree = O(n/2) = O(n)
# class Solution:
#     def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        
#         if not root:
#             return
        
#         q = collections.deque()
#         q.appendleft(root)
        
#         prev = None
        
#         while q:
            
#             size = len(q)
            
#             for i in range(size):
#                 curr = q.pop()
#                 if i!=0:
#                     prev.next = curr
#                 prev = curr
                
#                 if curr.left:
#                     q.appendleft(curr.left)
#                 if curr.right:
#                     q.appendleft(curr.right)
#         return root

# # Double DFS like in Symmetric tree
# # TC: O(n)
# # SC = O(h)
# class Solution:
#     def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        
#         if not root:
#             return
        
#         def dfs(left,right):
#             if not left:
#                 return
#             left.next = right
            
#             dfs(left.left,left.right)
#             dfs(left.right,right.left)
#             dfs(right.left,right.right)
            
        
#         dfs(root.left,root.right)
#         return root

# # Single DFS with realized connections
# # TC: O(n)
# # SC = O(h)
# class Solution:
#     def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        
#         if not root:
#             return
        
#         def dfs(root):
#             if not root.left:
#                 return
#             root.left.next = root.right
#             if root.next:
#                 root.right.next = root.next.left
            
#             dfs(root.left)
#             dfs(root.right)
        
#         dfs(root)
#         return root

# DFS with prev list of tree nodes (of size h)
# TC: O(n)
# SC = O(h)  + O(h) for recursive stack
class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if not root:
            return
        
        
        def dfs(root,prev_arr,level):
            if not root:
                return
            if level == len(prev_arr):
                # If this is the first node we encounter at this level, just add it to the prev_arr
                prev_arr.append(root)
            else:
                # If there is a element in prev_arr that element is the node before our current element
                # So mark the next of the node in the prev_arr as current node and update the prev)_arr value at this level to current node
                prev_arr[level].next = root
                prev_arr[level] = root
                
            dfs(root.left,prev_arr,level+1)
            dfs(root.right,prev_arr,level+1)
        
           
        dfs(root,[],0)
        return root