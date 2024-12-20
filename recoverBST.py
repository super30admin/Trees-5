# // Time Complexity :O(n)
# // Space Complexity :O(h)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# Recursive in-order T:O(n), S:O(h)
class Solution:
    def __init__(self):
        self.first = None
        self.second = None
        self.prev = None

    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.helper(root)
        self.first.val,self.second.val = self.second.val,self.first.val

    def helper(self, root):
        #basecase
        if not root: return 

        #recursion
        self.helper(root.left)

        if self.prev != None  and self.prev.val >= root.val:        #breach
            if not self.first:
                self.first = self.prev                              # if first isn't found second doesnt matter
            self.second = root
        self.prev = root

        self.helper(root.right)
        
# using stack T:O(n), S:O(h)
class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        first = None
        second = None
        prev = None
        st = []

        while st or root:
            while root: 
                st.append(root)
                root = root.left
            root = st.pop()

            if prev and prev.val >= root.val:                       #breach
                if not first:
                    first = prev
                second = root

            prev = root
            root = root.right

        first.val, second.val = second.val, first.val