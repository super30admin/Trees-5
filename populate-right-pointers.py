# Time Complexity: O(n)
# Space Complexity: O(n)
# Approach: Traverse the tree level by level. Keep track of a prev node at every node and point it's next pointer to the current node.
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
        if not root:
            return None
        q = collections.deque([root])
        
        while q:
            numnodes = len(q)
            prev = None
            for _ in range(numnodes):
                node = q.popleft()
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
                if prev:                
                    prev.next = node
                prev = node
                
        return root
                