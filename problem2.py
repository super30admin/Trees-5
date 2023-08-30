# Time Complexity: O(n)
# Space Complexity: O(n)
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next

class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if not root:
            return None

        que = []
        que.append(root) 

        while que:
            level_size = len(que)
            prev_node = None 

            for _ in range(level_size):
                node = que.pop(0) 

                if prev_node:
                    prev_node.next = node #curr node

                prev_node = node  # prev node

                if node.left:
                    que.append(node.left)
                if node.right:
                    que.append(node.right)

        return root
