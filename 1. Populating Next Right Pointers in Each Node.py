from collections import deque
class Solution:
    def connect(self, root):
        # Time - O(n)
        # Space - O(n)
        if root is None:
            return None
        q = deque()
        q.append(root)
        while q:
            qLen = len(q)
            curr = q.popleft()
            if curr.left:
                q.append(curr.left)
                q.append(curr.right)

            for i in range(1, qLen):
                temp = q.popleft()
                curr.next = temp
                if temp.left is not None:
                    q.append(temp.left)
                    q.append(temp.right)

                curr = temp

        return root


# Solution without extra space - Most optimal of the 3 solutions
class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        # Time - O(n)
        # Space - O(1)
        if root is None:
            return None
        level = root
        curr = root
        while level.left:
            while curr:
                curr.left.next = curr.right
                if curr.next:
                    curr.right.next = curr.next.left
                curr = curr.next
            level = level.left
            curr = level
        return root


# DFS Solution
class Solution:
    # Time - O(n)
    # Space - O(h)
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if root is None:
            return None
        self.dfs(root.left, root.right)
        return root

    def dfs(self, left, right):
        # Base
        if left is None:
            return

        # Logic
        left.next = right
        self.dfs(left.left, left.right)
        self.dfs(left.right, right.left)
        self.dfs(right.left, right.right)