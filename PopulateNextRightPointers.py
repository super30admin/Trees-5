"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

# Time: O(n) as traversing through all the nodes. Space: O(n) as well as we are using the queue data structure.
# Logic is to do a level order traversal and then except the last element, just point the next pointer to next element in that level

class Solution:
    def connectBFS(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if not root: return root
        queue = deque()
        queue.append(root)

        while queue:
            size = len(queue)
            for i in range(size):
                node = queue.popleft()
                if i != size - 1:
                    node.next = queue[0]
                if node.left:
                    queue.append(node.left)
                    queue.append(node.right)
        return root

    # Treating each level as a linked list as it has next pointers and then pointing them in order based on level and curr.
    # Time is O(n), however, space is better than BFS as we are not using a queue data structure. Hence O(1)
    def connectUsingLLLogic(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if not root: return root
        level = root
        while level.left != None:
            curr = level
            while curr != None:
                curr.left.next = curr.right
                if curr.next != None:
                    curr.right.next = curr.next.left
                curr = curr.next
            level = level.left
        return root

    #Time is O(n) and space is O(n) recursion depth. Logic is simple, we just chose left and right subtree and then point left.next to right. And do recursively for the others.
    def connectDFS(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if not root: return

        def helper(left, right):
            if left == None: return
            left.next = right
            helper(left.left, left.right)
            helper(left.right, right.left)
            helper(right.left, right.right)

        helper(root.left, root.right)
        return root
    #Time is O(n) and space is O(n) recursion depth.
    # Logic is similar to 2nd solution of Linked List. Just doing it via recursion instead of while loop
    def connectDFS1(self, root: "Optional[Node]") -> "Optional[Node]":
        if not root:
            return

        def helper(curr):
            if not curr.left:
                return
            curr.left.next = curr.right
            if curr.next:
                curr.right.next = curr.next.left
            helper(curr.left)
            helper(curr.right)

        helper(root)
        return root