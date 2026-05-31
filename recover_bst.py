class Solution:
    def __init__(self):
        self.prev = None
        self.first = None
        self.second = None

    def recoverTree(self, root):
        st = []

        while st or root:
            while root:
                st.append(root)
                root = root.left

            root = st.pop()

            if self.prev is not None and self.prev.val >= root.val:
                if self.first is None:
                    self.first = self.prev
                    self.second = root
                else:
                    self.second = root

            self.prev = root

            root = root.right

        temp = self.first.val
        self.first.val = self.second.val
        self.second.val = temp

# Time: O(n)
# Space: O(h)