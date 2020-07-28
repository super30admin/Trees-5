-------------------------------- Recover Binary Tree ---------------------------------------------
# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No
# 
# I will have a flag, prev , x and y global variables and iterate through the binary tree.
# When i found if the prev element is greater than the root.val, then if flag == 0 in the first breach, I will 
# will initialize x with prev and y with root, in the second breach I will initialize the y with root.
# Then we can swap both the nodes so that every node will be in ascending order.

class Solution:
    def recoverTree(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        def dfs(root: TreeNode):
            nonlocal x, y, prev, flag
            if not root:
                return
            
            dfs(root.left)
            if prev and root.val < prev.val:
                if flag == 0:
                    x = prev
                    y = root
                    flag = 1
                else:
                    y = root
                    
            prev = root
            dfs(root.right)
        
        x = y = prev = None
        flag = 0
        dfs(root)
        x.val, y.val = y.val, x.val