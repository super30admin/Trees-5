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
        #TC: O(V+E)
        #SC: O(1)
        # Approach - without using extra space for the queue
        # level pointer to keep checking the level
        # starting a curr pointer from that level to process nodes in that level

        if not root:
            return None
        level = root
        curr = root
        while level.left:
            curr = level
            while curr:
                curr.left.next = curr.right
                if curr.next:
                    curr.right.next = curr.next.left
                curr = curr.next
            level = level.left
        return root

        """
        # Approach - Above same logic using DFS
        if root is None: return None
        self.dfs(root)
        return root
    
    def dfs(self,root):
        if not root.left:
            return
        root.left.next = root.right
        if root.next:
            root.right.next = root.next.left
        self.dfs(root.left)
        self.dfs(root.right)
        """
        """
        #Approach 1: Do BFS and a queue so this will be extra space for the queue
        if not root: 
            return None
        q = deque()
        q.append(root)

        while(q):
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                if(i != size -1):
                    curr.next = q[0]
                if curr.left and curr.right:
                    q.append(curr.left)
                    q.append(curr.right)
        return root
        """
        