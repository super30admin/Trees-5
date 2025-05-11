# Time Complexity : O(n), where n is the number of nodes in the tree
# Space Complexity : O(h), where h is the height of the tree
# Approach : DFS
# 1. We use a recursive function to traverse the tree in a depth-first manner.
# 2. At each node, we mark the next pointer of the left child to point to the right child.
# 3. If the node we're standing at has a next pointer, we mark the next pointer of the right child to point to the left child of the next node.
# 4. We then recursively call the function on the left and right children of the current node.
class Solution:
    def connect(self, root):
        if not root: return None
        def dfs(node):
            if not node.left:
                return

            node.left.next = node.right
            if node.next:
                node.right.next = node.next.left
            
            dfs(node.left)
            dfs(node.right)

        dfs(root)
        return root

# Time Complexity : O(n), where n is the number of nodes in the tree
# Space Complexity : O(h), where h is the height of the tree
# Approach : DFS
# 1. In this approach, we make the next pointer connection for the node we're standing at, unlike in the previous approach where we made the connection for the left child.
# 2. We will need 2 nodes to make the connection, one for the left child and one for the right child.
# 3. We will need to do this for the following cases:
#    a. left.left and left.right
#    b. left.right and right.left
#    c. right.left and right.right
class Solution:
    def connect(self, root):
        if not root: return None
        def dfs(left, right):
            if not left: return

            left.next = right
            dfs(left.left, left.right)
            dfs(right.left, right.right)
            dfs(left.right, right.left)

        dfs(root.left, root.right)
        return root

# Time Complexity : O(n), where n is the number of nodes in the tree
# Space Complexity : O(1)
# Approach : Iterative
# 1. We use a while loop to traverse the tree level by level.
# 2. We start with the root node and move to the next level by using the left child of the current level.
# 3. We use a while loop to traverse the current level and make the next pointer connections.
# 4. We make the next pointer connection for the left child and right child of the current node.
# 5. If the current node has a next pointer, we make the next pointer connection for the right child of the current node to the left child of the next node.
# 6. We then move to the next node in the current level.
# 7. Finally, we move to the next level by using the left child of the current level.
class Solution:
    def connect(self, root):
        if not root: return None
        level = root
        while level.left:
            curr = level
            while curr:
                curr.left.next = curr.right
                if curr.next:
                    curr.right.next = curr.next.left
                curr = curr.next
            level = level.left
        return root

# Time Complexity : O(n), where n is the number of nodes in the tree
# Space Complexity : O(n), where n is the number of nodes in the tree
# Approach : Iterative
# 1. We use a queue to traverse the tree level by level.
# 2. We start with the root node and add it's children to the queue.
# 3. At each level, we pop the first node from the queue and make its next pointer connection to the next node in the queue.
# 4. Add the left and right children of the current node to the queue.
# 5. We repeat this process until the queue is empty.
# 6. Finally, we return the root node.
from collections import deque
class Solution:
    def connect(self, root):
        q = deque()
        q.append(root)

        if not root:
            return None
        while q:
            size = len(q)
            for i in range(size):
                node = q.popleft()
                if node and i != size-1:
                    node.next = q[0]
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
        return root