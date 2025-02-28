# Time Complexity: O(n)
# Space Complexity: O(n)
class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if not root:
            return None

        q = deque([root])

        while q:
            size = len(q)
            prev = None
            for i in range(size):
                curr = q.popleft()
                if prev:
                    prev.next = curr
                prev = curr
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)

        return root