# Time Complexity: O(N) 
# Space Complexity: O(H) 


class Solution(object):
    def recoverTree(self, root):
        self.first, self.last, self.prev = None, None, None
        self.inorder(root)
        # Swap it if you see a breach
        self.first.val, self.last.val = self.last.val, self.first.val
        return root

    def inorder(self, root):
        #base
        if not root:
            return
        # logic 
        self.inorder(root.left)
        if self.prev != None and self.prev.val >= root.val:
            # First breach
            if not self.first: # Here instead of flag it will take care.
                self.first = self.prev
                self.last = root
            # Second breach
            else:
                self.last = root
        # update prev to root
        self.prev = root
        self.inorder(root.right)
