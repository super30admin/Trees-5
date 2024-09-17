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
        #Time and Space : O(n)
        if root is None:
            return
        queue = deque()
        queue.append(root)
        
        while queue:
            size = len(queue)
            prev,cur = queue.popleft(),None
            if prev.left is not None:
                queue.append(prev.left)
            if prev.right is not None:
                queue.append(prev.right)
            for i in xrange(1,size):
                cur = queue.popleft()
                prev.next = cur
                prev = cur
                if prev.left is not None:
                    queue.append(prev.left)
                if prev.right is not None:
                    queue.append(prev.right)
        return root
