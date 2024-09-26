"""
Time Complexity: O(N)
Space Complexity: O(N) As we are making use of queue which contains N items
Compiled on leetcode?: Yes
"""
class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if not root:
            return root
        queue = []
        queue.append(root)
        while queue:
            size = len(queue)
            for i in range(size):
                currentNode = queue.pop(0)
                if currentNode.left:
                    queue.append(currentNode.left)
                if currentNode.right:    
                    queue.append(currentNode.right)
                if i == size - 1:
                    break
                else:
                    currentNode.next = queue[0]
        return root 