#Approach
#do the level order traversal at the end of the each order add null


#Complexities
#Time: o(n)
#Space: O(n)

# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next


class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        queue = []

        if root == None:
            return

        queue.append(root)
        while queue:
            size = len(queue)
            prev = None

            for i in range(size):
                node = queue.pop(0)
                if prev != None:
                    prev.next = node

                if node.left:
                    queue.append(node.left)

                if node.right:
                    queue.append(node.right)
                prev = node

            prev.next = None

        return root





