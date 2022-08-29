class Solution:
    # Time Complexity : o(N)
    # space Complexity : o(N)
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if not root:
            return root
        lvl = root
        while lvl.left:
            curr = lvl
            while curr:
                curr.left.next = curr.right
                if curr.next:
                    curr.right.next = curr.next.left
                curr = curr.next
            lvl = lvl.left
        return root

    # Time Complexity : o(N)
    # space Complexity : o(N)
    def helper(self, left, right):
        if not left:
            return
        left.next = right
        self.helper(left.left, left.right)
        self.helper(left.right, right.left)
        self.helper(right.left, right.right)

    # Time Complexity : o(N)
    # space Complexity : o(N)
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if not root:
            return root
        queue = [root]
        while queue:
            prev = None
            size = len(queue)
            for i in range(size):
                curr = queue.pop(0)
                if i>0:
                    prev.next = curr

                if curr.left:
                    queue.append(curr.left)
                    queue.append(curr.right)
                prev = curr
        return root