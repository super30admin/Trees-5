
#Time Complexity: O(N)
#Space Compexity: O(N)
from collections import deque
class Solution(object):
    def connect(self, root):
        """
        :type root: Node
        :rtype: Node
        """

        queue = deque([root])
        if root is None:
            return root

        while queue:
            size = len(queue)
            prev = None  

            for i in range(size):
                node = queue.popleft()
                
                if prev:
                    prev.next = node  
                prev = node  

                if node.left is not None:
                    queue.append(node.left)
                    queue.append(node.right)

            node.next = None

        return root



        
        

