# Time Complexity: O(n)
# Space Complexity: O(b) where b is the breadth of the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
The code conducts a BFS across the tree. At each level, it connects the nodes to the next node in the queue 
and adds a None to the queue at the end of each level. While statement depends on the length as a None will 
alwyas be present in the queue.
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

class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if root == None: return None

        q = deque()
        q.append(root)
        q.append(None)

        while len(q) > 1:
            for i in range(len(q)):
                node = q.popleft()
                if node == None: continue
                q.append(node.left)
                q.append(node.right)
                node.next = q[0]
            q.append(None)

        return root