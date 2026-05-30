import deque

class Solution:
    # def connect(self, root):
    #     if not root:
    #         return root
    #     dq = deque()
    #     dq.append(root)
    #     while dq:
    #         qs = len(dq)
    #         for i in range(qs):
    #             front = dq.popleft()
    #             if i != qs - 1:
    #                 front.next = dq[0]
    #             if front.left:
    #                 dq.append(front.left)
    #             if front.right:
    #                 dq.append(front.right)
    #     return root

    # def connect(self, root):
    #     if not root:
    #         return root
    #     level = root
    #     while level.left:
    #         curr = level
    #         while curr:
    #             curr.left.next = curr.right
    #             if curr.next:
    #                 curr.right.next = curr.next.left
    #             curr = curr.next
    #         level = level.left
    #     return root
    
    def connect(self, root):
        if not root:
            return None
        self.dfs(root)
        return root

    def dfs(self, root):
        if not root.left and not root.right:
            return
        root.left.next = root.right
        if root.next:
            root.right.next = root.next.left
        self.dfs(root.left)
        self.dfs(root.right)