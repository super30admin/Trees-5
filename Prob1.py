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

        #Method 1 - BFS - TC and SC - O(n)
        # if not root: return None
        # q=deque()
        # q.append(root)
        # while q:
        #     size=len(q)
        #     for i in range(size):
        #         curr=q.popleft()
        #         if i!=size-1: #if it's the last element in the level, do nothing, else connect it to the top of the q.
        #             curr.next=q[0]
        #         if curr.left: #cause its a pefect bin tree, if left exists, right will be there for sure.
        #             q.append(curr.left)
        #             q.append(curr.right)
        # return root
        
        #Method 2 - Optimized BFS - TC - O(n) and SC - O(1)
        # if not root: return None
        # level=root
        # while level.left:
        #     curr=level
        #     while curr:
        #         curr.left.next=curr.right
        #         if curr.next:
        #             curr.right.next=curr.next.left
        #         curr=curr.next
        #     level=level.left
        # return root

        #Method 3 - DFS - same logic, different way of iterating the tree. 
        # TC - O(n) and SC - O(n)
        if not root: return None

        def dfs(curr):
            #base
            if not curr.left: return 

            #logic
            curr.left.next=curr.right
            if curr.next:
                curr.right.next=curr.next.left
            dfs(curr.left)
            dfs(curr.right)
        
        dfs(root)
        return root


