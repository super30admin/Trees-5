class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if root == None:
            return None
        q = deque()
        q.append(root)
        while q:
            size = len(q)
            prev = q.popleft()
            if prev.left != None:
                q.append(prev.left)
                q.append(prev.right)
            for i in range(1, size):
                curr = q.popleft()
                prev.next = curr
                if curr.left != None:
                    q.append(curr.left)
                    q.append(curr.right)
                prev = curr
        return root

# Time Complexity: O(n)
# Space Complexity: O(n) Used Queue



class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if root == None:
            return None
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

# Time Complexity: O(n)
# Space Complexity: O(1) 


class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if root == None:
            return None
        self.dfs(root.left, root.right)
        return root
    
    def dfs(self, left, right):
        if left == None or right == None:
            return
        left.next = right
        self.dfs(left.left, left.right)
        self.dfs(left.right, right.left)
        self.dfs(right.left, right.right)

# Time Complexity: O(n)
# Space Complexity: O(n)  Using recursive stack space