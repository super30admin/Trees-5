#I used a queue (deque from the collections module) to perform a breadth-first search. Initially, the root node is added to the queue. For each level of the tree, I determined the number of nodes (n) and processed each node by setting its next pointer to the next node in the queue, except for the last node in the level. Then, I added the left and right children of each node to the queue for processing in the next iteration. This continues until all levels of the tree are processed. The time complexity of this solution is O(n) where n is the number of nodes, as each node is visited once. The space complexity is also O(n) in the worst case, which occurs when the tree is completely unbalanced and the queue needs to store all nodes at a single level.

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
        q=deque([root])
        while q:
            n=len(q)
            for i in range(n):
                node=q.popleft()
                if i<n-1:
                    node.next=q[0]
                if node and node.left:
                    q.append(node.left)
                if node and node.right:
                    q.append(node.right)
        return root

        