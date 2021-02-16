# Time: O(N) - BFS approach without creating a queue
# Space: O(1) - BFS without queue space

class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if not root:
            return 
        level = root
        while level.left != None:
            curr = level
            while curr != None  :
                curr.left.next = curr.right
                if curr.next != None:
                    curr.right.next = curr.next.left
                curr = curr.next
            level = level.left
        return root
