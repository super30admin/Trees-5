from queue import Queue

class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':

        # DFS
        # TC: O(n), SC: O(h)
        if not root:
            return

        def dfs(left, right):
            if not left:
                return

            left.next = right

            dfs(left.left, left.right)
            dfs(left.right, right.left)
            dfs(right.left, right.right)

        dfs(root.left, root.right)

        return root

        # No space solution
        # TC: O(n) SC: O(1)
        if not root:
            return

        left = root

        while left.left:
            curr = left
            while curr:
                curr.left.next = curr.right
                if curr.next:
                    curr.right.next = curr.next.left
                curr = curr.next
            left = left.left

        return root


        # BFS 
        # TC: O(n) SC: O(n)
        if not root:
            return
        if not root.left and not root.right:
            return root
        
        q = Queue()
        q.put(root.left)
        q.put(root.right)

        while not q.empty():
            count = q.qsize()
            prev = q.get()
            # Checking for left only because it is a Perfect Binary Tree
            if prev.left:
                q.put(prev.left)
                q.put(prev.right)
            for i in range(count-1):
                curr = q.get()
                prev.next = curr
                prev = curr
                if curr.left:
                    q.put(curr.left)
                    q.put(curr.right)

        return root 
