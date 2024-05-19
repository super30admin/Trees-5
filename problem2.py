#Time Complexity : O(n)
#Space Complexity : O(n)
#Any problem you faced while coding this : -

#The approach is to use iterative traversal. First of all, two main pointers are maintained - previous and root whenever a first breach is detected. Then we simply swap the nodes to obtain the original tree.
class Solution:
    def __init__(self):
        self.first = None
        self.second = None
        self.prev = None

    def recoverTree(self, root: Optional[TreeNode]) -> None:
        self.inorder(root)
        temp = self.first.val
        self.first.val = self.second.val
        self.second.val = temp

    def inorder(self, root):
        st = list()
        while len(st) != 0 or root != None:
            while root != None:
                st.append(root)
                root = root.left

            root = st.pop()
            if self.prev != None and self.prev.val >= root.val:
                if self.first == None:
                    self.first = self.prev
                    self.second = root
                else:
                    self.second = root

            self.prev = root
            root = root.right

        