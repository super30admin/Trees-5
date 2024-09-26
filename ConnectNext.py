-------------------------------- Recover Binary Tree ---------------------------------------------
# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No
# 
# first we wil connect the root.left and root.right with next pointer and check if the root has next 
# then we can connect the root.right pointer to root.next.left pointer. Once we connect these we can recursively 
# go to each and every node and connect all nodes.


class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if not root:
            return
        
        def dfs(root):
            if not root:
                return 
            
            if root.left and root.right:
                root.left.next = root.right
                if root.next:
                    root.right.next = root.next.left
            
            
            dfs(root.left)
            dfs(root.right)
            
            return root
        
        return dfs(root)