# // Time Complexity : O(n) where h is the height
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
#
#
# // Your code here along with comments explaining your approach
#Using BFS Method
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next

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

# // Time Complexity : O(n) where h is the height
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
#
#
# // Your code here along with comments explaining your approach
#Using Pointers

# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next


class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if root == None:
            return None
        level = root
        #Level Order Traversal
        while level.left != None:
            curr = level
            while curr!=None:
                curr.left.next = curr.right
                if curr.next != None:
                    curr.right.next = curr.next.left
                # Move Curr pointer until curr.next is not null
                curr = curr.next
            # Move level pointer until level.left is not null
            level = level.left
        return root

#Recursive Solution

# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next


class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if root == None:
            return None
        self.dfs(root.left, root.right)
        return root

    def dfs(self, left, right):
        #Base
        if left == None:
            return
        #Logic
        left.next = right
        self.dfs(left.left, left.right)
        self.dfs(left.right, right.left)
        self.dfs(right.left, right.right)