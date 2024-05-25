## Problem2 Recover Binary Search Tree(https://leetcode.com/problems/recover-binary-search-tree/)

# Approach
# Set first, second and prev Node to None. Do inorder traversal on the tree. 
# If (self.prev != None and self.prev.val >= root.val), check if first == None. If yes, set self.first = self.prev and self.second = root 
# else: self.second = root. Set prev = root. Swap first.val and second.val. Return root


# Time Complexity: O(n)
# Space Complexity: O(h)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def dfs(self,root):
        # base
        if root == None:
            return

        #logic
        self.dfs(root.left)
        
        if (self.prev != None and self.prev.val >= root.val):
            if self.first is None:
                self.first = self.prev
                self.second = root
            else:
                self.second = root
        self.prev = root
       
        self.dfs(root.right)



    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
     
        self.prev = None
        self.first = None
        self.second = None

        self.dfs(root)

        temp = self.first.val
        self.first.val = self.second.val
        self.second.val = temp

        return root