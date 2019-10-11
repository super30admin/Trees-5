# Time Complexity : O(N) (Where N is number of nodes in tree)
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english:
# - Use bfs with queue to get all nodes on same level.
# - Use prev variable and initialize it to None before every level.
# - At every node, assign prev node's next pointer to current node and update prev node to current node.

"""
# Definition for a Node.
class Node:
    def __init__(self, val, left, right, next):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""
class Solution:
    def connect(self, root: 'Node') -> 'Node':
        queue = []
        
        if root:
        
            queue.append(root)

            while(queue):
                qlength = len(queue)
                prev = None

                for i in range(qlength):
                    current = queue.pop(0)
                    if prev:
                        prev.next = current
                    prev = current
                    if current.left and current.right:
                        queue.append(current.left)
                        queue.append(current.right)

            return root
