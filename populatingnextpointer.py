
# // Time Complexity :O(h)
# // Space Complexity :O(k)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No
"""
# Definition for a Node.
class Node:
    def __init__(self, val, left, right, next):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""
from collections import deque
class Solution:
    def connect(self, root: 'Node') -> 'Node':
        """
      1 (1)
    2 (2)->    3(1)
 4(4) -> 5(3) -> 6(2) -> 7(1)

"""
        if root ==  None:
            return None
        q = deque([root])
        while q:  # [1] [3,4,5]
            size = len(q) # 1 2
            while size > 0: #  > 0
                node = q.popleft() # node =1,2,3
                if size > 1 :# 
                    node.next = q[0] #  2.next = 3
                size -= 1          # size =1
                
                if node.left:         
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
        return root