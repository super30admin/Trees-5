"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""


class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        # Approach 1 Use BFS to point nodes to next level wise
        # Time O(n)
        # Space O(h)
        # if not root: return root
        # lvl = prevlvl = 0
        # q = deque()
        # q.append((root,0))
        # levelnode = []

        # while q:
        #     curr,lvl = q.popleft()

        #     if lvl != prevlvl:
        #         for i in range(len(levelnode) - 1):
        #             levelnode[i].next = levelnode[i+1]
        #         levelnode = []
        #         prevlvl = lvl
        #     levelnode.append(curr)

        #     if curr.left:
        #         q.append((curr.left, lvl+1))
        #         q.append((curr.right, lvl+1))

        # for i in range(len(levelnode) - 1):
        #             levelnode[i].next = levelnode[i+1]
        # return root

        # Approach 2 Use BFS to utilize the next pointers of the parents
        # Time O(n)
        # Space O(1)
        # if not root: return
        # level = root
        # while level.left:
        #     curr = level
        #     while curr:
        #         curr.left.next = curr.right
        #         if curr.next:
        #             curr.right.next = curr.next.left
        #         curr = curr.next

        #     level = level.left

        # return root

        # Approach 3 Use DFS to recursively point next pointers to subordinatinig pointers
        # Time O(n)
        # Space O(h)

        # if not root: return
        # def dfs(left, right):
        #     if not left or left.next==right: return

        #     left.next = right
        #     dfs(left.left, left.right)
        #     dfs(left.right, right.left)
        #     dfs(right.left, right.right)
        # dfs(root.left, root.right)
        # return root

        # Approach 4 DFS Similar to approach 2
        # Time O(n)
        # Space O(h)

        def dfs(root):
            if not root.left: return

            root.left.next = root.right
            if root.next:
                root.right.next = root.next.left
            dfs(root.left)
            dfs(root.right)

        if not root: return
        dfs(root)
        return root












